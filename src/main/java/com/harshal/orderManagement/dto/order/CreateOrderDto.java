package com.harshal.orderManagement.dto.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

public record CreateOrderDto(
        @NotNull(message = "Customer id is required")
        Long customerId,

        @NotEmpty(message = "At least one grocery item is required")
        List<Long> groceryItemIds
) {
}
