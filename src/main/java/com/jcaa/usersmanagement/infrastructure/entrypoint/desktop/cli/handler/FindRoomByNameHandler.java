package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.RoomController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.RoomResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class FindRoomByNameHandler implements OperationHandler {
    private final RoomController roomController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        console.println("\n  --- Find Room By Unique Name ---");
        final String name = console.readRequired("  Enter Target Room Name: ");
        final RoomResponse response = roomController.getRoomByName(name);

        console.println("\n  Match Found:");
        console.printf("    Number: %d%n", response.number());
        console.printf("    Name:   %s%n", response.name());
        console.printf("    Status: %s%n", response.status());
    }
}
