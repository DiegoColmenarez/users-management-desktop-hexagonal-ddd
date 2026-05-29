package com.jcaa.usersmanagement.domain.exception;

public class RoomNotFoundException extends DomainException {
    public RoomNotFoundException(String message) {
        super(message);
    }

    private static final String MESSAGE_BY_NUM = "La sala %d no ha sido encontrada";

    public static RoomNotFoundException becauseNumRoomWasNotFound(final Integer numRoom) {
        return new RoomNotFoundException(String.format(MESSAGE_BY_NUM, numRoom));
    }
}
