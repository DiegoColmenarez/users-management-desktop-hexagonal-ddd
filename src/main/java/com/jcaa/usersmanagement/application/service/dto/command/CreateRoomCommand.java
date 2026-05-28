package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateRoomCommand(
        @NotNull(message = "El número de sala es obligatorio") Integer number,
        @NotBlank(message = "El nombre de la sala no puede estar vacío") String name
) {}
