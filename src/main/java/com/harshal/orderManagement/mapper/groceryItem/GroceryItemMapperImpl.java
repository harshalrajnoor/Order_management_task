package com.harshal.orderManagement.mapper.groceryItem;

import com.harshal.orderManagement.dto.groceryItems.CreateGroceryItemDto;
import com.harshal.orderManagement.dto.groceryItems.GroceryItemResponseDto;
import com.harshal.orderManagement.entity.GroceryItem;
import org.springframework.stereotype.Component;

@Component
public class GroceryItemMapperImpl implements GroceryItemMapper {
    @Override
    public GroceryItem fromDto(CreateGroceryItemDto dto) {
        return GroceryItem.builder()
                .name(dto.name())
                .price(dto.price())
                .quantity(dto.quantity())
                .category(dto.category())
                .build();
    }

    @Override
    public GroceryItemResponseDto toDto(GroceryItem groceryItem) {
        return GroceryItemResponseDto.builder()
                .id(groceryItem.getId())
                .name(groceryItem.getName())
                .price(groceryItem.getPrice())
                .quantity(groceryItem.getQuantity())
                .category(groceryItem.getCategory())
                .build();
    }
}
