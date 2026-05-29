package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.RoomController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DeleteRoomHandler implements OperationHandler {
    private final RoomController roomController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        console.println("\n  --- Delete Room Record ---");
        final int number = console.readInt("  Enter Room Number to delete: ");
        roomController.deleteRoom(number);
        console.println("\n  [SUCCESS] Room wiped out cleanly from data source.");
    }
}
