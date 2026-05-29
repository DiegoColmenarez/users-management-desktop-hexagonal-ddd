package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateRoomCommand(
        @NotNull(message = "El número de la sala es obligatorio") Integer number,
        @NotBlank(message = "El nuevo nombre no puede estar vacío") String newName
) {}
