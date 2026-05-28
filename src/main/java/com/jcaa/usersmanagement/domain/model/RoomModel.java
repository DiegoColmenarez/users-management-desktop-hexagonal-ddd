package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.enums.RoomStatus;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;

public class RoomModel {
    private RoomName roomName;
    private RoomNum roomNum;
    private RoomStatus roomStatus;

    private RoomModel(RoomName roomName, RoomNum roomNum, RoomStatus roomStatus) {
        this.roomName = roomName;
        this.roomNum = roomNum;
        this.roomStatus = roomStatus;
    }

    public static RoomModel factoryRoom(RoomName name, RoomNum num, RoomStatus status){
      return  new RoomModel(name, num, status);
    }

}
