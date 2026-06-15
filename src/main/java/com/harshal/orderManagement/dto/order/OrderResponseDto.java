package com.harshal.orderManagement.dto.order;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record OrderResponseDto(
        Long id,
        LocalDateTime orderDate,
        BigDecimal totalPrice,
        Long customerId,
        List<Long> groceryItemIds
) {
}
