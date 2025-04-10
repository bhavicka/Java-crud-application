package com.bhavika.crudapplication.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

//Data Transfer Object for POST
public record UserDto(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotEmpty
        String userName,

        @NotEmpty
        String email,
        String password,
        @NotEmpty
        String role,
        @Past
        LocalDate birthDate) {
}