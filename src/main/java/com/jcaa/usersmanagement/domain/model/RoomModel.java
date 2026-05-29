package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.enums.RoomStatus;
import com.jcaa.usersmanagement.domain.valueobject.RoomName;
import com.jcaa.usersmanagement.domain.valueobject.RoomNum;
import com.jcaa.usersmanagement.domain.exception.InvalidRoomStateException;

public class RoomModel {
    private RoomName roomName;
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

    public static RoomModel reconstitute(RoomName name, RoomNum num, RoomStatus status) {
        return new RoomModel(name, num, status);
    }

    public void rename(RoomName newName) {
        this.roomName = newName;
    }

    public void enable() {
        if (this.roomStatus == RoomStatus.ENABLED) {
            throw InvalidRoomStateException.becauseRedundantTransition(this.roomStatus.name(), this.roomNum.num());
        }
        this.roomStatus = RoomStatus.ENABLED;
    }

    public void disable() {
        if (this.roomStatus == RoomStatus.DISABLED) {
            throw InvalidRoomStateException.becauseRedundantTransition(this.roomStatus.name(), this.roomNum.num());
        }
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