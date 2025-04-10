package com.bhavika.crudapplication.user;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

//DTO for GET
public record UserResponseDto(
        String userName,
        String firstName,
        String lastName,
        String role,
        LocalDate birthDate
) {
}
