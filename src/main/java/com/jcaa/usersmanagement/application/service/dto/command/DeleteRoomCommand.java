package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotNull;

public record DeleteRoomCommand(
        @NotNull(message = "El número de la sala no puede estar vacío")
        Integer number
) {}