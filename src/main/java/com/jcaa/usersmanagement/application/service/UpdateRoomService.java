package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.UpdateRoomUseCase;
import com.jcaa.usersmanagement.application.port.out.GetRoomByNumPort;
import com.jcaa.usersmanagement.application.port.out.SaveRoomPort;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateRoomCommand;
import com.jcaa.usersmanagement.domain.enums.RoomStatus;
import com.jcaa.usersmanagement.domain.exception.RoomNotFoundException;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import java.util.Set;

@RequiredArgsConstructor
public final class UpdateRoomService implements UpdateRoomUseCase {

    private final GetRoomByNumPort getRoomByNumPort;
    private final SaveRoomPort saveRoomPort;
    private final Validator validator;

    @Override
    public RoomModel execute(final UpdateRoomCommand command) {
        validateCommand(command);
        final RoomNum roomNum = new RoomNum(command.number());
        RoomModel existingRoom = getRoomByNumPort.getByNum(roomNum)
                .orElseThrow(() -> RoomNotFoundException.becauseNumRoomWasNotFound(roomNum.num()));

        if (!command.newName().equals(existingRoom.roomName())) {
            existingRoom.rename(new RoomName(command.newName()));
        }

        RoomStatus targetStatus = RoomStatus.valueOf(command.newStatus().toUpperCase());

        if (targetStatus == RoomStatus.ENABLED && existingRoom.roomStatus() != RoomStatus.ENABLED) {
            existingRoom.enable();
        } else if (targetStatus == RoomStatus.DISABLED && existingRoom.roomStatus() != RoomStatus.DISABLED) {
            existingRoom.disable();
        }

        return saveRoomPort.save(existingRoom);
    }

    private void validateCommand(final UpdateRoomCommand command) {
        final Set<ConstraintViolation<UpdateRoomCommand>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}