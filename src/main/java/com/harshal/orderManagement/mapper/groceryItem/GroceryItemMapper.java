package com.harshal.orderManagement.mapper.groceryItem;

import com.harshal.orderManagement.dto.groceryItems.CreateGroceryItemDto;
import com.harshal.orderManagement.dto.groceryItems.GroceryItemResponseDto;
import com.harshal.orderManagement.entity.GroceryItem;

public interface GroceryItemMapper {
    GroceryItem fromDto(CreateGroceryItemDto dto);

    GroceryItemResponseDto toDto(GroceryItem groceryItem);
}
