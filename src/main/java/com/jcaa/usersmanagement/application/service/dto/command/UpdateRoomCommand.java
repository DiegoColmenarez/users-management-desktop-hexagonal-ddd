package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateRoomCommand(
        @NotNull(message = "El número de la sala es obligatorio")
        Integer number,

        @NotBlank(message = "El nuevo nombre no puede estar vacío")
        String newName,

        @NotBlank(message = "El estado es obligatorio")
        @Pattern(regexp = "ENABLED|DISABLED", message = "El estado debe ser ENABLED o DISABLED")
        String newStatus
) {}
