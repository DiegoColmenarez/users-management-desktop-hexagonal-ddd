package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.RoomController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.UpdateRoomRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.RoomResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UpdateRoomHandler implements OperationHandler {
    private final RoomController roomController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        console.println("\n  --- Update Room Properties ---");
        final int number = console.readInt("  Enter Room Number to update: ");

        final RoomResponse currentRoom = roomController.getRoomByNum(number);
        console.println("  [Sala Actual] Nombre: " + currentRoom.name() + " | Estado: " + currentRoom.status());

        console.println("\n  ¿Qué deseas actualizar?");
        console.println("  1. Solo el Nombre");
        console.println("  2. Solo el Estado (ENABLED / DISABLED)");
        console.println("  3. Ambos");
        final int option = console.readInt("  Elige una opción (1-3): ");

        String newName = currentRoom.name();
        String newStatus = currentRoom.status();

        if (option == 1 || option == 3) {
            newName = console.readRequired("  Enter New Room Name: ");
        }
        if (option == 2 || option == 3) {
            newStatus = console.readRequired("  Enter New Status (ENABLED / DISABLED): ");
        }

        // AQUÍ: Como tu Request ya acepta Integer como primer dato, le pasamos 'number' directo
        final UpdateRoomRequest request = new UpdateRoomRequest(number, newName, newStatus);

        final RoomResponse response = roomController.updateRoom(request);

        console.println("\n  [SUCCESS] Room Updated:");
        console.printf("    Number: %s%n", response.number());
        console.printf("    Name:   %s%n", response.name());
        console.printf("    Status: %s%n", response.status());
    }
}