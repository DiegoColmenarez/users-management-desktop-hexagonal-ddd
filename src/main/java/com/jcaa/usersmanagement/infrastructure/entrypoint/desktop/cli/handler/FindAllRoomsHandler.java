package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.RoomController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.RoomResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class FindAllRoomsHandler implements OperationHandler {
    private final RoomController roomController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        console.println("\n  --- List All Rooms ---");
        final List<RoomResponse> rooms = roomController.getAllRooms();

        if (rooms.isEmpty()) {
            console.println("  [INFO] No rooms found in the database.");
            return;
        }

        console.println("  [SUCCESS] Rooms List:");
        for (RoomResponse room : rooms) {
            console.printf("    - Number: %d | Name: %s | Status: %s%n",
                    room.number(), room.name(), room.status());
        }
    }
}