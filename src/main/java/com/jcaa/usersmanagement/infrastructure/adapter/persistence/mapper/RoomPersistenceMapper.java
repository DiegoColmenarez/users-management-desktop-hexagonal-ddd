package com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper;

import com.jcaa.usersmanagement.domain.enums.RoomStatus;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity.RoomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomPersistenceMapper {

    public static RoomEntity toEntity(RoomModel model) {
        return new RoomEntity(
                model.roomNum(),
                model.roomName(),
                model.roomStatus().name()
        );
    }

    public static RoomModel toDomain(ResultSet rs) throws SQLException {
        return RoomModel.reconstitute(
                new RoomName(rs.getString("nombreSala")),
                new RoomNum(rs.getInt("numSala")),
                RoomStatus.valueOf(rs.getString("salaStatus"))
        );
    }
}