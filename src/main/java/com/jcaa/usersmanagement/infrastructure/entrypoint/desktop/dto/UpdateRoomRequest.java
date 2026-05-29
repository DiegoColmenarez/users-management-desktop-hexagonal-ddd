package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto;

public record UpdateRoomRequest(
        Integer number,
        String newName,
        String newStatus
) {}