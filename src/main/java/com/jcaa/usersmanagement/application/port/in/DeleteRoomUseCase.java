package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.DeleteRoomCommand;

public interface DeleteRoomUseCase {
    void execute(DeleteRoomCommand command);
}
