package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import java.util.Optional;

public interface GetRoomByNamePort {
    Optional<RoomModel> getByName(RoomName roomName);
}