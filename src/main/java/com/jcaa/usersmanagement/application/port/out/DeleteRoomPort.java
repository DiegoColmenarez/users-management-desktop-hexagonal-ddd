package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.valueobject.RoomNum;

public interface DeleteRoomPort {
    void delete(RoomNum roomNum);
}
