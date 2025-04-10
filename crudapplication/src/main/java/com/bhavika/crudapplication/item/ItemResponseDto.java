package com.bhavika.crudapplication.item;

import com.bhavika.crudapplication.category.Category;

public record ItemResponseDto(
        String itemName,
        long itemPrice,
        Category itemCategory,
        String itemDescription,
        boolean inStock
) {
}
