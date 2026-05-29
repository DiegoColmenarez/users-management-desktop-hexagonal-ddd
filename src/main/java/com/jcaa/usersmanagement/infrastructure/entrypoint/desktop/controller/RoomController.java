package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller;

import com.jcaa.usersmanagement.application.port.in.*;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreateRoomRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.RoomResponse;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.UpdateRoomRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.mapper.RoomDesktopMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class RoomController {

    private final CreateRoomUseCase createRoomUseCase;
    private final UpdateRoomUseCase updateRoomUseCase;
    private final DeleteRoomUseCase deleteRoomUseCase;
    private final GetRoomByNumUseCase getRoomByNumUseCase;
    private final GetRoomByNameUseCase getRoomByNameUseCase;

    public RoomResponse createRoom(final CreateRoomRequest request) {
        final var command = RoomDesktopMapper.toCreateCommand(request);
        final var room = createRoomUseCase.execute(command);
        return RoomDesktopMapper.toResponse(room);
    }

    public RoomResponse updateRoom(final UpdateRoomRequest request) {
        final var command = RoomDesktopMapper.toUpdateCommand(request);
        final var room = updateRoomUseCase.execute(command);
        return RoomDesktopMapper.toResponse(room);
    }

    public void deleteRoom(final Integer number) {
        final var command = RoomDesktopMapper.toDeleteCommand(number);
        deleteRoomUseCase.execute(command);
    }

    public RoomResponse getRoomByNum(final Integer number) {
        final var room = getRoomByNumUseCase.execute(number);
        return RoomDesktopMapper.toResponse(room);
    }

    public RoomResponse getRoomByName(final String name) {
        final var room = getRoomByNameUseCase.execute(name);
        return RoomDesktopMapper.toResponse(room);
    }
}