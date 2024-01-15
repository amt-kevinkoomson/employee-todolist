package com.kevosolulu.employeemanagement.model;
import java.time.LocalDateTime;

public record User(
        Integer id,
        String username,
        String email,
        String password,
        Role role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
