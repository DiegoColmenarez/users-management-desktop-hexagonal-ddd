package com.jcaa.usersmanagement.domain.exception;

public class InvalidRoomNameException extends DomainException{
    public InvalidRoomNameException(String message) {
        super(message);
    }
    private static final String MESSAGE_EMPTY = "No puede estar vacio, por favor ingrese un nombre valido";
    private static final String MESSAGE_TOO_SHORT = "Nombre demasiado corto, por facor ingrese un nombre valido. carateres minimos: %d";

    public static InvalidRoomNameException nameIsEmpty() {
        return new InvalidRoomNameException(MESSAGE_EMPTY);
    }

    public static InvalidRoomNameException nameLengthIsTooShort(final int minimumLength) {
        return new InvalidRoomNameException(String.format(MESSAGE_TOO_SHORT, minimumLength));
    }
}