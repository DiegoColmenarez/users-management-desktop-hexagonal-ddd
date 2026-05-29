package com.jcaa.usersmanagement;

import com.jcaa.usersmanagement.infrastructure.config.DependencyContainer;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.RoomManagementCli;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.UserManagementCli;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(final String[] args) {
    log.info("Starting Hotel Management System...");
    final DependencyContainer container = new DependencyContainer();

    try (final Scanner scanner = new Scanner(System.in)) {
      final ConsoleIO console = new ConsoleIO(scanner, System.out);
      boolean exit = false;

      while (!exit) {
        console.println("\n######################################");
        console.println("        EVENTOS PARA CONGRESO      ");
        console.println("######################################");
        console.println("  1. User Management");
        console.println("  2. Room Management");
        console.println("  3. Exit Application");

        int option = console.readInt("\n  Select module: ");

        switch (option) {
          case 1 -> {
            // Arranca el menú de usuarios original
            new UserManagementCli(container.userController(), console).start();
          }
          case 2 -> {
            // Arranca tu nuevo menú de salas (usando el controlador del container)
            new RoomManagementCli(container.roomController(), console).run();
          }
          case 3 -> {
            log.info("Shutting down system. Goodbye!");
            exit = true;
          }
          default -> console.println("  [WARNING] Invalid module option. Please try again.");
        }
      }
    }
  }
}