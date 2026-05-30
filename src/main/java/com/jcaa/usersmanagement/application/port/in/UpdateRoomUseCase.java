package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.UpdateRoomCommand;
import com.jcaa.usersmanagement.domain.model.RoomModel;

public interface UpdateRoomUseCase {
    RoomModel execute(UpdateRoomCommand command);
}