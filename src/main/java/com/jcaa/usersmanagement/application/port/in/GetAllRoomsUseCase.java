package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.RoomModel;

import java.util.List;

public interface GetAllRoomsUseCase {
    List<RoomModel> excute();
}
