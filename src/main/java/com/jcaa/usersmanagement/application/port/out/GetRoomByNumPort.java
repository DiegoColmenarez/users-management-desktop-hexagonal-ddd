package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.RoomModel;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import java.util.Optional;

public interface GetRoomByNumPort {
    Optional<RoomModel> getByNum(RoomNum roomNum);
}