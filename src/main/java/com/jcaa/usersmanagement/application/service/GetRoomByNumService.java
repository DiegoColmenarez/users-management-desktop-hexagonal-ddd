package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetRoomByNumUseCase;
import com.jcaa.usersmanagement.application.port.out.GetRoomByNumPort;
import com.jcaa.usersmanagement.domain.exception.RoomNotFoundException;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class GetRoomByNumService implements GetRoomByNumUseCase {

    private final GetRoomByNumPort getRoomByNumPort;

    @Override
    public RoomModel excute(Integer num) {
        final RoomNum roomNum = new RoomNum(num);
        return getRoomByNumPort.getByNum(roomNum)
                .orElseThrow(() -> RoomNotFoundException.becauseNumRoomWasNotFound(roomNum.num()));
    }
}