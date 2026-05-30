package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.CreateRoomUseCase;
import com.jcaa.usersmanagement.application.port.out.GetRoomByNumPort;
import com.jcaa.usersmanagement.application.port.out.SaveRoomPort;
import com.jcaa.usersmanagement.application.service.dto.command.CreateRoomCommand;
import com.jcaa.usersmanagement.domain.exception.RoomAlreadyExistsException;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;


import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
public final class CreateRoomService implements CreateRoomUseCase {

    private final SaveRoomPort saveRoomPort;
    private final GetRoomByNumPort getRoomByNumPort;
    private final Validator validator;

    @Override
    public RoomModel execute(final CreateRoomCommand command) {
        validateCommand(command);
        final RoomNum roomNum = new RoomNum(command.number());
        RoomNumberIsNotTaken(roomNum);
        final RoomName roomName = new RoomName(command.name());
        final RoomModel roomToSave = RoomModel.factoryRoom(roomName, roomNum);
        return saveRoomPort.save(roomToSave);
    }

    private void validateCommand(final CreateRoomCommand command) {
        final Set<ConstraintViolation<CreateRoomCommand>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    private void RoomNumberIsNotTaken(final RoomNum roomNum) {
        Optional<RoomModel> room = getRoomByNumPort.getByNum(roomNum);
        if (room.isPresent()) {
            throw RoomAlreadyExistsException.becauseRoomAlreadyExists(roomNum.num());
        }
    }
}
