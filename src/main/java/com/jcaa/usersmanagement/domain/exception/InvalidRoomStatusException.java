package com.jcaa.usersmanagement.domain.exception;

public class InvalidRoomStatusException extends DomainException {
    public InvalidRoomStatusException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "El estatus '%s' no es valido.";
    private static final String STATUS_EMPTY = "El estado está vacío, por favor corrija";
    private static final String REDUNDANT_TRANSITION = "La sala %d ya se encuentra en estado %s. Transición redundante rechazada.";

    public static InvalidRoomStatusException statusIsInvalid(final String status) {
        return new InvalidRoomStatusException(String.format(MESSAGE_INVALID, status));
    }
    public static InvalidRoomStatusException becauseRedundantTransition(String currentStatus, Integer roomNum) {
        return new InvalidRoomStatusException((String.format(REDUNDANT_TRANSITION, roomNum, currentStatus)));
    }

    public static InvalidRoomStatusException becauseStatusIsEmpty() {
        return new InvalidRoomStatusException((STATUS_EMPTY));
    }
}