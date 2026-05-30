package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;

public record DeleteRoomCommand(
        @NotBlank(message = "El número de la sala no puede estar vacío")
        Integer number
) {}