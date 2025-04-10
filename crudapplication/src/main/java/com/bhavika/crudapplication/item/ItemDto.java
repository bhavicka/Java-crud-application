package com.bhavika.crudapplication.item;

import com.bhavika.crudapplication.category.Category;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public record ItemDto(
        String itemName,
        long itemPrice,
        int count,
        Integer itemCategory,
        String itemDescription,
        boolean inStock
) {
}
