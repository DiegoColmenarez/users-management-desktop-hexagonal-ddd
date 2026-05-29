package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.RoomModel;

public interface SaveRoomPort {
    RoomModel save(RoomModel room);
}
