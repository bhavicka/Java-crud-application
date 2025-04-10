package com.bhavika.crudapplication.category;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> saveCategory(
            @Valid @RequestBody CategoryDto categoryDto
    ){
        return categoryService.saveCategory(categoryDto);
    }

    @PostMapping("/categories")
    public List<ResponseEntity<CategoryDto>> saveCategories(
            @Valid @RequestBody List<CategoryDto>   categoryDtoList
    ){
        return categoryService.saveCategories(categoryDtoList);
    }

    @GetMapping("/categories")
    public List<ResponseEntity<CategoryDto>> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{name}")
    public CategoryDto getByName(
            @PathVariable String name){
        return categoryService.getByName(name);
    }

    @GetMapping("/category/sort/asc")
    public List<String> getCategoryNamesSortedByItemCount() {
        return categoryService.getCategoryNamesSortedByItemCount();
    }

    @GetMapping("/category/count/{name}")
    public int getItemCountByName(
            @PathVariable String name
    ){
        return categoryService.getItemCountByName(name);
    }

    @GetMapping("category/count")
    public long getCategoryCount(){
        return categoryService.getCategoryCount();
    }

    @GetMapping("category/item_list/{name}")
    public List<String> getItemList(@PathVariable String name){
        return categoryService.getItemList(name);
    }

}
