package com.jcaa.usersmanagement.domain.exception;

public class InvalidRoomNumException  extends DomainException{
    public InvalidRoomNumException(String message) {
        super(message);
    }
    private static final String MESSAGE_NEGATIVE_NUM = "EL numero asignado es negativo, no es valido.";
    private static final String MESSAGE_NULL_ARGUMENT= "EL numero asignado es NULL, no es valido.";
    public static InvalidRoomNumException numIsNegative(){
        return new InvalidRoomNumException(MESSAGE_NEGATIVE_NUM);
    }
    public static InvalidRoomNumException numIsNull(){
        return new InvalidRoomNumException(MESSAGE_NULL_ARGUMENT);
    }
}
