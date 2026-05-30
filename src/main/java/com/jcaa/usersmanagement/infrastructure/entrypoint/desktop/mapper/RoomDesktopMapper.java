package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.mapper;

import com.jcaa.usersmanagement.application.service.dto.command.CreateRoomCommand;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteRoomCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateRoomCommand;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreateRoomRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.RoomResponse;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.UpdateRoomRequest;

public final class RoomDesktopMapper {

    public static CreateRoomCommand toCreateCommand(CreateRoomRequest request) {
        return new CreateRoomCommand(request.number(), request.name());
    }

    public static UpdateRoomCommand toUpdateCommand(UpdateRoomRequest request) {
        return new UpdateRoomCommand(request.number(), request.newName(), request.newStatus());
    }

    public static DeleteRoomCommand toDeleteCommand(Integer number) {
        return new DeleteRoomCommand(number);
    }

    public static RoomResponse toResponse(RoomModel room) {
        return new RoomResponse(
                room.roomNum(),
                room.roomName(),
                room.roomStatus().name()
        );
    }
}