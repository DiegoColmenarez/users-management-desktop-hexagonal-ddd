package com.jcaa.usersmanagement.domain.exception;

public class InvalidRoomStateException extends DomainException {
    private static final String STATUS_EMPTY = "El estado está vacío, por favor corrija";
    private static final String STATUS_INVALID = "El estado '%s' es inválido, por favor corrija";
    private static final String REDUNDANT_TRANSITION = "La sala %d ya se encuentra en estado %s. Transición redundante rechazada.";

    private InvalidRoomStateException(String message) {
        super(message);
    }

    public static InvalidRoomStateException becauseStatusIsEmpty() {
        return new InvalidRoomStateException(STATUS_EMPTY);
    }

    public static InvalidRoomStateException becauseStatusIsInvalid(String invalidStatus) {
        return new InvalidRoomStateException(String.format(STATUS_INVALID, invalidStatus));
    }

    public static InvalidRoomStateException becauseRedundantTransition(String currentStatus, Integer roomNum) {
        return new InvalidRoomStateException(String.format(REDUNDANT_TRANSITION, roomNum, currentStatus));
    }
}
