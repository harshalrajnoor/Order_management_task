package com.harshal.orderManagement.controller;

import com.harshal.orderManagement.dto.order.CreateOrderDto;
import com.harshal.orderManagement.dto.order.OrderResponseDto;
import com.harshal.orderManagement.entity.Order;
import com.harshal.orderManagement.mapper.order.OrderMapperImpl;
import com.harshal.orderManagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Validated
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapperImpl orderMapper;

    @PostMapping()
    public OrderResponseDto createOrder(@RequestBody CreateOrderDto createOrderDto) {
        return orderMapper.toDto(orderService.createOrder(createOrderDto));
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders()
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @GetMapping("/{order_id}")
    public OrderResponseDto getOrderById(@PathVariable("order_id") Long id) {
        return orderMapper.toDto(orderService.getOrderById(id));
    }

    @PutMapping("/{order_id}")
    public OrderResponseDto updateOrder(
            @RequestBody CreateOrderDto dto,
            @PathVariable("order_id") Long id) {
        return orderMapper.toDto(orderService.updateOrder(dto, id));
    }

    @DeleteMapping("/{order_id}")
    public void deleteOrder(@PathVariable("order_id") Long id) {
        orderService.deleteOrder(id);
    }

}
