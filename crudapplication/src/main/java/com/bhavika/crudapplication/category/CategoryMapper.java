package com.bhavika.crudapplication.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public Category toCategory(CategoryDto categoryDto){
        if(categoryDto == null)
            throw new NullPointerException("CategoryDto object is null");
        Category category = new Category();
        category.setCategoryName(categoryDto.categoryName());
//        category.setItemCount(categoryDto.itemCount());
        category.setDescription(categoryDto.description());
        return category;
    }
    public CategoryDto toCategoryDto(Category category){
        return new CategoryDto(
                category.getCategoryName(),
//                category.getItemCount(),
                category.getDescription()
        );
    }
}
