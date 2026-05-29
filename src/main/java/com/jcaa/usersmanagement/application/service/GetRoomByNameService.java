package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetRoomByNameUseCase;
import com.jcaa.usersmanagement.application.port.out.GetRoomByNamePort;
import com.jcaa.usersmanagement.domain.exception.RoomNotFoundException;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class GetRoomByNameService implements GetRoomByNameUseCase {

    private final GetRoomByNamePort getRoomByNamePort;

    @Override
    public RoomModel excute(String name) {
        final RoomName roomName = new RoomName(name);
        return getRoomByNamePort.getByName(roomName).orElseThrow(() -> RoomNotFoundException.becauseNameRoomWasNotFound(roomName.name()));
    }
}