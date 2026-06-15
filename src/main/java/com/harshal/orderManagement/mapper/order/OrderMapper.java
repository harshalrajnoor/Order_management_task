package com.harshal.orderManagement.mapper.order;

import com.harshal.orderManagement.dto.order.CreateOrderDto;
import com.harshal.orderManagement.dto.order.OrderResponseDto;
import com.harshal.orderManagement.entity.Order;

public interface OrderMapper {
    Order fromDto(CreateOrderDto createOrderDto);

    OrderResponseDto toDto(Order order);
}
