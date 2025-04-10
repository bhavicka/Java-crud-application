package com.bhavika.crudapplication.category;

import jakarta.validation.constraints.NotEmpty;

public record CategoryDto (
        @NotEmpty
        String categoryName,
//        long itemCount,
        String description
){ }
