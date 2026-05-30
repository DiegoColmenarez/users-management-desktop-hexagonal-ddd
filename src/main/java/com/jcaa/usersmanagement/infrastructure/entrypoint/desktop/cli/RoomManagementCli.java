package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler.*;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.menu.RoomMenuOption;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.RoomController;

import java.util.Optional;

public class RoomManagementCli {

    private final ConsoleIO console;
    private final CreateRoomHandler createRoomHandler;
    private final UpdateRoomHandler updateRoomHandler;
    private final DeleteRoomHandler deleteRoomHandler;
    private final FindRoomByNumHandler findRoomByNumHandler;
    private final FindRoomByNameHandler findRoomByNameHandler;
    private final FindAllRoomsHandler findAllRoomsHandler;

    public RoomManagementCli(RoomController roomController, ConsoleIO console) {
        this.console = console;
        this.createRoomHandler = new CreateRoomHandler(roomController, console);
        this.updateRoomHandler = new UpdateRoomHandler(roomController, console);
        this.deleteRoomHandler = new DeleteRoomHandler(roomController, console);
        this.findRoomByNumHandler = new FindRoomByNumHandler(roomController, console);
        this.findRoomByNameHandler = new FindRoomByNameHandler(roomController, console);
        this.findAllRoomsHandler = new FindAllRoomsHandler(roomController, console);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            console.println("\n==================================");
            console.println("       ROOM MANAGEMENT SYSTEM     ");
            console.println("==================================");

            for (RoomMenuOption option : RoomMenuOption.values()) {
                console.printf("  %d. %s%n", option.getNumber(), option.getDescription());
            }

            int choice = console.readInt("\n  Select an option: ");
            Optional<RoomMenuOption> menuOption = RoomMenuOption.fromNumber(choice);

            if (menuOption.isEmpty()) {
                console.println("  [WARNING] Invalid option. Please try again.");
                continue;
            }

            try {
                switch (menuOption.get()) {
                    case CREATE_ROOM -> createRoomHandler.handle();
                    case UPDATE_ROOM -> updateRoomHandler.handle();
                    case DELETE_ROOM -> deleteRoomHandler.handle();
                    case FIND_ROOM_BY_NUM -> findRoomByNumHandler.handle();
                    case FIND_ROOM_BY_NAME -> findRoomByNameHandler.handle();
                    case FIND_ALL_ROOMS -> findAllRoomsHandler.handle();
                    case EXIT -> {
                        console.println("  Exiting Room Management System... Returning to Main Menu.");
                        exit = true;
                    }
                }
            } catch (Exception e) {
                console.println("  [ERROR] " + e.getMessage());
            }
        }
    }
}