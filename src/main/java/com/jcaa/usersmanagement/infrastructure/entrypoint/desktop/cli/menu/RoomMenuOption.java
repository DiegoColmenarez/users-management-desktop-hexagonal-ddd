package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.menu;

import java.util.Optional;

public enum RoomMenuOption {
    CREATE_ROOM(1, "Create Room"),
    UPDATE_ROOM(2, "Update Room"),
    DELETE_ROOM(3, "Delete Room"),
    FIND_ROOM_BY_NUM(4, "Find Room by Number"),
    FIND_ROOM_BY_NAME(5, "Find Room by Name"),
    FIND_ALL_ROOMS(6, "List All Rooms"),
    EXIT(7, "Exit");

    private final int number;
    private final String description;

    RoomMenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() { return number; }
    public String getDescription() { return description; }

    public static Optional<RoomMenuOption> fromNumber(int number) {
        for (RoomMenuOption option : values()) {
            if (option.getNumber() == number) {
                return Optional.of(option);
            }
        }
        return Optional.empty();
    }
}