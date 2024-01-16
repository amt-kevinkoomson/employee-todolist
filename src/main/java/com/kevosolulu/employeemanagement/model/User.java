package com.kevosolulu.employeemanagement.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record User(
        Integer id,
        @NotBlank
        String username,
        @Email
        String email,
        @NotBlank
        String password,
        Role role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
