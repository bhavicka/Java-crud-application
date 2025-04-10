package com.bhavika.crudapplication.item;

import com.bhavika.crudapplication.category.Category;
import com.bhavika.crudapplication.category.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {
    CategoryRepository categoryRepository;
    ItemMapper(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public Item toItem(ItemDto itemDto){
        if(itemDto == null)
            throw new NullPointerException("ItemDto is null");
        Item item = new Item();
        item.setItemName(itemDto.itemName());
        item.setItemPrice(itemDto.itemPrice());
        item.setCount(itemDto.count());
        Category category = categoryRepository.findById(itemDto.itemCategory()).orElseThrow();
        item.setItemCategory(category);
        item.setItemDescription(itemDto.itemDescription());
        item.setInStock(itemDto.inStock());
        return item;
    }

    public ItemResponseDto toItemResponseDto(Item item){
        return  new ItemResponseDto(
                item.getItemName(),
                item.getItemPrice(),
                item.getItemCategory(),
                item.getItemDescription(),
                item.isInStock()
        );
    }
}
