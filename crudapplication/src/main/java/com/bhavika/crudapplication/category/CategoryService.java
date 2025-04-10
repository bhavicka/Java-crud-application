package com.bhavika.crudapplication.category;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(
            CategoryRepository categoryRepository,
            CategoryMapper categoryMapper
    ){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public ResponseEntity<CategoryDto> saveCategory(CategoryDto categoryDto){
        Category category = categoryMapper.toCategory(categoryDto);
        categoryRepository.save(category);
        return ResponseEntity.ok(categoryDto);
    }

    public List<ResponseEntity<CategoryDto>> saveCategories(List<CategoryDto> categoryDtoList){
        List<Category> categoryList =   categoryDtoList
                .stream()
                .map(categoryMapper::toCategory)
                .toList();
        categoryRepository.saveAll(categoryList);
        return categoryDtoList
                .stream()
                .map(ResponseEntity::ok)
                .toList();
    }

//    public String getNameById(Integer id){
//        return categoryRepository.getCategoryNameById(id);
//    }

    public List<ResponseEntity<CategoryDto>> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(categoryMapper::toCategoryDto)
                .toList()
                .stream()
                .map(ResponseEntity::ok)
                .toList();
    }

    public CategoryDto getByName(String name){
        Category category = categoryRepository.findByCategoryName(name);
        return categoryMapper.toCategoryDto(category);
    }

    public List<String> getCategoryNamesSortedByItemCount(){
        return categoryRepository.findCategoryNamesSortedByItemCount();
    }

    public int getItemCountByName(String categoryName){
        return categoryRepository.getItemCountByCategoryName(categoryName);
    }

    public long getCategoryCount() {
        return categoryRepository.count();
    }

    public List<String> getItemList(String name){
        return categoryRepository.getItemLisByCategoryName(name);
    }


}
