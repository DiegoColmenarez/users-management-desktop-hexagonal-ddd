package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.RoomModel;
import java.util.List;

public interface GetAllRoomsPort {
    List<RoomModel> getAll();
}