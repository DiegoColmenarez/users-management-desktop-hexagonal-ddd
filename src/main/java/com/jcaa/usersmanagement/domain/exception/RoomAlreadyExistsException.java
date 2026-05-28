package com.jcaa.usersmanagement.domain.exception;

public class RoomAlreadyExistsException extends DomainException {

    private static final String MESSAGE_ROOM_EXISTS = "La sala numero '%d' ya existe.";

    public RoomAlreadyExistsException(String message) {
        super(message);
    }

    public static RoomAlreadyExistsException becauseRoomAlreadyExists(final Integer num) {
        return new RoomAlreadyExistsException(String.format(MESSAGE_ROOM_EXISTS, num));
    }
}