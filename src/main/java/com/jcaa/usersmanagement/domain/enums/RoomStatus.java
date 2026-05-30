package com.jcaa.usersmanagement.domain.enums;

import com.jcaa.usersmanagement.domain.exception.InvalidRoomStatusException;

public enum RoomStatus {
    ENABLED, DISABLED;

    public static RoomStatus fromString(final String value) {
        for (final RoomStatus status : values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw InvalidRoomStatusException.statusIsInvalid(value);
    }
}
