package com.bhavika.crudapplication.item;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    ItemService service;

    ItemController(ItemService service){
        this.service = service;
    }

    @PostMapping("/item")
    public ResponseEntity<ItemResponseDto> saveItem(
            @Valid @RequestBody ItemDto itemDto) {
        return service.saveItem(itemDto);
    }
    @PostMapping("/items")
    public List<ResponseEntity<ItemResponseDto>> saveItems(
            @Valid @RequestBody List<ItemDto> itemDto) {
        return service.saveItems(itemDto);
    }
}
