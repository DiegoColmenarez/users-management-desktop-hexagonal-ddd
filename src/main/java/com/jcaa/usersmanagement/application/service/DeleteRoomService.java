package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.DeleteRoomUseCase;
import com.jcaa.usersmanagement.application.port.out.DeleteRoomPort;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DeleteRoomService implements DeleteRoomUseCase {

    private final DeleteRoomPort deleteRoomPort;

    @Override
    public void execute(Integer roomNumber) {
        final RoomNum roomNum = new RoomNum(roomNumber);
        deleteRoomPort.delete(roomNum);
    }
}