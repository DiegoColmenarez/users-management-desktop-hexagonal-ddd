package com.jcaa.usersmanagement.infrastructure.adapter.persistence.repository;

import com.jcaa.usersmanagement.application.port.out.*;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.config.DatabaseConfig;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.config.DatabaseConnectionFactory;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity.RoomEntity;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper.RoomPersistenceMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomRepositoryMySQL implements
        SaveRoomPort, GetRoomByNumPort, GetRoomByNamePort, GetAllRoomsPort, DeleteRoomPort {

    private final DatabaseConfig config;

    public RoomRepositoryMySQL(DatabaseConfig config) {
        this.config = config;
    }

    @Override
    public RoomModel save(RoomModel roomModel) {
        boolean exists = getByNum(new RoomNum(roomModel.roomNum())).isPresent();

        String sql;
        if (exists) {
            sql = "UPDATE SALA SET nombreSala = ?, salaStatus = ? WHERE numSala = ?";
        } else {
            sql = "INSERT INTO SALA (nombreSala, salaStatus, numSala) VALUES (?, ?, ?)";
        }

        RoomEntity entity = RoomPersistenceMapper.toEntity(roomModel);

        try (Connection conn = DatabaseConnectionFactory.createConnection(this.config);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.name());
            stmt.setString(2, entity.status());
            stmt.setInt(3, entity.number());

            stmt.executeUpdate();
            return roomModel;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la sala en BD: " + e.getMessage());
        }
    }

    @Override
    public Optional<RoomModel> getByNum(RoomNum roomNum) {
        String sql = "SELECT * FROM SALA WHERE numSala = ?";
        try (Connection conn = DatabaseConnectionFactory.createConnection(this.config);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, roomNum.num());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(RoomPersistenceMapper.toDomain(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar la sala por número: " + e.getMessage());
        }
    }

    @Override
    public Optional<RoomModel> getByName(RoomName roomName) {
        String sql = "SELECT * FROM SALA WHERE nombreSala = ?";
        try (Connection conn = DatabaseConnectionFactory.createConnection(this.config);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, roomName.name());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(RoomPersistenceMapper.toDomain(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar la sala por nombre: " + e.getMessage());
        }
    }

    @Override
    public List<RoomModel> getAll() {
        String sql = "SELECT * FROM SALA";
        List<RoomModel> rooms = new ArrayList<>();

        try (Connection conn = DatabaseConnectionFactory.createConnection(this.config);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                rooms.add(RoomPersistenceMapper.toDomain(rs));
            }
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar las salas: " + e.getMessage());
        }
    }

    @Override
    public void delete(RoomNum roomNum) {
        String sql = "DELETE FROM SALA WHERE numSala = ?";
        try (Connection conn = DatabaseConnectionFactory.createConnection(this.config);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, roomNum.num());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la sala: " + e.getMessage());
        }
    }
}