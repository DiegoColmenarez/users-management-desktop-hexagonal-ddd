package com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity;

public record RoomEntity(
        Integer number,
        String name,
        String status
) {}