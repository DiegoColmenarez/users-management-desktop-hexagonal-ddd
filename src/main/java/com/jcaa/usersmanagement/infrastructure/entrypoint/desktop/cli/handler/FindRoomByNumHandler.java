package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.RoomController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.RoomResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class FindRoomByNumHandler implements OperationHandler {
    private final RoomController roomController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        console.println("\n  --- Find Room By PK (Number) ---");
        final int number = console.readInt("  Enter Target Room Number: ");
        final RoomResponse response = roomController.getRoomByNum(number);

        console.println("\n  Match Found:");
        console.printf("    Number: %d%n", response.number());
        console.printf("    Name:   %s%n", response.name());
        console.printf("    Status: %s%n", response.status());
    }
}
