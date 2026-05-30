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
    log.info("Starting Eventos Management System...");
    final DependencyContainer container = new DependencyContainer();

    try (final Scanner scanner = new Scanner(System.in)) {
      final ConsoleIO console = new ConsoleIO(scanner, System.out);
      boolean exit = false;

      while (!exit) {
        console.println("\n######################################");
        console.println("        EVENTOS PARA CONGRESO      ");
        console.println("######################################");
        console.println("  1. User Management");
        console.println("  2. Sala Management");
        console.println("  3. Salir");

        int option = console.readInt("\n  Select module: ");

        switch (option) {
          case 1 -> {
            new UserManagementCli(container.userController(), console).start();
          }
          case 2 -> {
            new RoomManagementCli(container.roomController(), console).run();
          }
          case 3 -> {
            log.info("Adios.");
            exit = true;
          }
          default -> console.println("  [WARNING] invalido, intenta otra vez");
        }
      }
    }
  }
}