package com.harshal.orderManagement.mapper.order;

import com.harshal.orderManagement.dto.order.CreateOrderDto;
import com.harshal.orderManagement.dto.order.OrderResponseDto;
import com.harshal.orderManagement.entity.GroceryItem;
import com.harshal.orderManagement.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order fromDto(CreateOrderDto createOrderDto) {
        return Order.builder()
                .orderDate(LocalDateTime.now())
                .build();
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        return OrderResponseDto.builder()
                .id(order.getId())
                .customerId(order.getCustomer().getId())
                .totalPrice(order.getTotalPrice())
                .orderDate(order.getOrderDate())
                .groceryItemIds(order.getGroceryItems().stream().map(GroceryItem::getId).toList())
                .build();
    }
}
