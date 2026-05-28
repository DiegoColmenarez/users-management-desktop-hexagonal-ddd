package com.jcaa.usersmanagement.domain.exception;

public class InvalidRoomStatusException extends DomainException {
    public InvalidRoomStatusException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "El estatus '%s' no es valido.";

    public static InvalidRoomStatusException statusIsInvalid(final String status) {
        return new InvalidRoomStatusException(String.format(MESSAGE_INVALID, status));
    }
}