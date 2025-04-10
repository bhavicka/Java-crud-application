package com.bhavika.crudapplication.item;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ItemService {
    ItemMapper mapper;
    ItemRepository repository;

    public ItemService(ItemMapper mapper, ItemRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    public ResponseEntity<ItemResponseDto> saveItem(ItemDto itemDto){
        return ResponseEntity.ok(mapper.toItemResponseDto(repository.save(mapper.toItem(itemDto))));
    }

    public List<ResponseEntity<ItemResponseDto>> saveItems(List<ItemDto> itemDtos){
        List<Item> items = itemDtos
                .stream()
                .map(mapper::toItem)
                .toList();
        repository.saveAll(items);
        List<ItemResponseDto> itemResponseDto = items
                .stream()
                .map(mapper::toItemResponseDto)
                .toList();
        return itemResponseDto.stream().map(ResponseEntity::ok).toList();

    }
}
