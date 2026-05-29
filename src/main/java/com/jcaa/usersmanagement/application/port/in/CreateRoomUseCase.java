package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.CreateRoomCommand;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface CreateRoomUseCase {
    RoomModel execute(@NotNull @Valid CreateRoomCommand command);
}