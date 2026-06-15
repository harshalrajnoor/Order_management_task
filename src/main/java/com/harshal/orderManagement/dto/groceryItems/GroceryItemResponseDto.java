package com.harshal.orderManagement.dto.groceryItems;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record GroceryItemResponseDto(
        Long id,
        String name,
        String category,
        BigDecimal price,
        Integer quantity
) {
}
