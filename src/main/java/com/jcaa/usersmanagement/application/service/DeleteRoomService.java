package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.DeleteRoomUseCase;
import com.jcaa.usersmanagement.application.port.out.DeleteRoomPort;
import com.jcaa.usersmanagement.application.port.out.GetRoomByNumPort;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteRoomCommand;
import com.jcaa.usersmanagement.domain.exception.RoomNotFoundException;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public final class DeleteRoomService implements DeleteRoomUseCase {

    private final DeleteRoomPort deleteRoomPort;
    private final GetRoomByNumPort getRoomByNumPort;
    private final Validator validator;

    @Override
    public void execute(final DeleteRoomCommand command) {
        validateCommand(command);
        final RoomNum roomNum = new RoomNum(command.number());
        ensureRoomExists(roomNum);
        deleteRoomPort.delete(roomNum);
    }

    private void validateCommand(final DeleteRoomCommand command) {
        final Set<ConstraintViolation<DeleteRoomCommand>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    private void ensureRoomExists(final RoomNum roomNum) {
        getRoomByNumPort
                .getByNum(roomNum)
                .orElseThrow(() -> RoomNotFoundException.becauseNumRoomWasNotFound(roomNum.num()));
    }
}