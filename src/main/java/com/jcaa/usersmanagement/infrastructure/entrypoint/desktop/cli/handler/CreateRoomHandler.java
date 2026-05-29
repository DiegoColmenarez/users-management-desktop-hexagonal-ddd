package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.RoomController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreateRoomRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.RoomResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CreateRoomHandler implements OperationHandler {
    private final RoomController roomController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        console.println("\n  --- Create New Room ---");
        final int number = console.readInt("  Enter Room Number: ");
        final String name = console.readRequired("  Enter Room Name: ");

        final CreateRoomRequest request = new CreateRoomRequest(number, name);
        final RoomResponse response = roomController.createRoom(request);

        console.println("\n  [SUCCESS] Room Registry Saved:");
        console.printf("    Number: %d%n", response.number());
        console.printf("    Name:   %s%n", response.name());
        console.printf("    Status: %s%n", response.status());
    }
}