package com.harshal.orderManagement.service;

import com.harshal.orderManagement.dto.order.CreateOrderDto;
import com.harshal.orderManagement.entity.Customer;
import com.harshal.orderManagement.entity.GroceryItem;
import com.harshal.orderManagement.entity.Order;
import com.harshal.orderManagement.exception.CustomerNotFoundException;
import com.harshal.orderManagement.exception.GroceryItemNotFoundException;
import com.harshal.orderManagement.exception.OrderNotFoundException;
import com.harshal.orderManagement.repository.CustomerRepository;
import com.harshal.orderManagement.repository.GroceryItemsRepository;
import com.harshal.orderManagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final GroceryItemsRepository groceryItemsRepository;

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(CreateOrderDto dto) {
        Customer customer = customerRepository.findById(dto.customerId())
                .orElseThrow(() -> new CustomerNotFoundException(dto.customerId()));


        List<GroceryItem> groceryItems = groceryItemsRepository.findAllById(dto.groceryItemIds());

        BigDecimal totalPrice = groceryItems.stream()
                .map(GroceryItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = Order.builder()
                .customer(customer)
                .groceryItems(groceryItems)
                .totalPrice(totalPrice)
                .build();

        return orderRepository.save(order);
    }

    public Order updateOrder(CreateOrderDto dto, Long id) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        Customer customer = customerRepository.findById(dto.customerId())
                .orElseThrow(() -> new CustomerNotFoundException(dto.customerId()));

        List<GroceryItem> groceryItems = groceryItemsRepository.findAllById(dto.groceryItemIds());

        BigDecimal totalPrice = groceryItems.stream()
                .map(GroceryItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        existingOrder.setCustomer(customer);
        existingOrder.setGroceryItems(groceryItems);
        existingOrder.setTotalPrice(totalPrice);

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
