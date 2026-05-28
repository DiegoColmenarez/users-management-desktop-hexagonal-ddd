package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidRoomNameException;

import java.util.Objects;

public record RoomName(String name) {
    private static final int MINIMUM_LENGTH = 3;

    public RoomName {
        final String normalizedName = Objects.requireNonNull(name, "UserName cannot be null").trim();
        validateNotEmpty(normalizedName);
        validateMinimumLength(normalizedName);
        name = normalizedName;
    }

    private static void validateNotEmpty(final String normalizedName) {
        if (normalizedName.isEmpty()) {
            throw InvalidRoomNameException.nameIsEmpty();
        }
    }

    private static void validateMinimumLength(final String normalizedName) {
        if (normalizedName.length() < MINIMUM_LENGTH) {
            throw InvalidRoomNameException.nameLengthIsTooShort(MINIMUM_LENGTH);
        }
    }
}