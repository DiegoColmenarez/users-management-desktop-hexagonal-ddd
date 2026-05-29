package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetAllRoomsUseCase;
import com.jcaa.usersmanagement.application.port.out.GetAllRoomsPort;
import com.jcaa.usersmanagement.domain.model.RoomModel;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public final class GetAllRoomsService implements GetAllRoomsUseCase {
    private final GetAllRoomsPort getAllRoomsPort;

    @Override
    public List<RoomModel> execute() {
        return getAllRoomsPort.getAll();
    }
}
