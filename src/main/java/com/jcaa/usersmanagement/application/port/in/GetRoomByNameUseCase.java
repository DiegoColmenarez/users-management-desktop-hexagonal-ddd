package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.RoomModel;

public interface GetRoomByNameUseCase {
    RoomModel execute(String name);
}
