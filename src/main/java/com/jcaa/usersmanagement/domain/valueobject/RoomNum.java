package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidRoomNumException;


public record RoomNum(Integer num) {
    public RoomNum {
        validateNotNull(num);
        validateNotNegative(num);
    }

    private static void validateNotNull(final Integer num) {
        if (num == null) {
            throw InvalidRoomNumException.numIsNull();
        }
    }
    private static void validateNotNegative(final Integer num) {
        if (num < 1) {
            throw InvalidRoomNumException.numIsNegative();
        }
    }
}
