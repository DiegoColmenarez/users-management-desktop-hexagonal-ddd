package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.enums.RoomStatus;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;

public class RoomModel {
    private final RoomName roomName;
    private final RoomNum roomNum;
    private RoomStatus roomStatus;

    private RoomModel(RoomName roomName, RoomNum roomNum, RoomStatus roomStatus) {
        this.roomName = roomName;
        this.roomNum = roomNum;
        this.roomStatus = roomStatus;
    }

    public static RoomModel factoryRoom(RoomName name, RoomNum num) {
        return new RoomModel(name, num, RoomStatus.ENABLED);
    }

    public void enable() {
        this.roomStatus = RoomStatus.ENABLED;
    }
    public void disable() {
        this.roomStatus = RoomStatus.DISABLED;
    }

    public String roomName() {
        return this.roomName.name();
    }

    public Integer roomNum() {
        return this.roomNum.num();
    }
    public RoomStatus roomStatus(){
        return this.roomStatus;
    }
}