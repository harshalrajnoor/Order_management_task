package com.harshal.orderManagement.controller;

import com.harshal.orderManagement.dto.groceryItems.CreateGroceryItemDto;
import com.harshal.orderManagement.dto.groceryItems.GroceryItemResponseDto;
import com.harshal.orderManagement.entity.GroceryItem;
import com.harshal.orderManagement.mapper.groceryItem.GroceryItemMapper;
import com.harshal.orderManagement.mapper.groceryItem.GroceryItemMapperImpl;
import com.harshal.orderManagement.service.GroceryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery-items")
@RequiredArgsConstructor
@Validated
public class GroceryItemController {
    private final GroceryItemService groceryItemService;
    private final GroceryItemMapperImpl groceryItemMapper;

    @PostMapping()
    public GroceryItemResponseDto createGroceryItem(@RequestBody CreateGroceryItemDto dto) {
        GroceryItem groceryItem = groceryItemMapper.fromDto(dto);
        return groceryItemMapper.toDto(groceryItemService.createGroceryItemById(groceryItem));
    }

    @GetMapping
    public List<GroceryItemResponseDto> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems().stream().map(groceryItemMapper::toDto).toList();
    }

    @GetMapping("/{grocery_item_id}")
    public GroceryItemResponseDto getGroceryItemById(@PathVariable("grocery_item_id") Long id) {
        return groceryItemMapper.toDto(groceryItemService.getGroceryItemById(id));
    }

    @PutMapping("/{grocery_item_id}")
    public GroceryItemResponseDto updateGroceryItem(@RequestBody CreateGroceryItemDto dto, @PathVariable("grocery_item_id") Long id) {
        GroceryItem groceryItem = groceryItemMapper.fromDto(dto);
        return groceryItemMapper.toDto(groceryItemService.updateGroceryItem(groceryItem, id));
    }

    @DeleteMapping("/{grocery_item_id}")
    public void deleteGroceryItemById(@PathVariable("grocery_item_id") Long id) {
        groceryItemService.deleteGroceryItem(id);
    }
}
