package com.harshal.orderManagement.controller;

import com.harshal.orderManagement.dto.customer.CreateCustomerDto;
import com.harshal.orderManagement.dto.customer.CustomerResponseDto;
import com.harshal.orderManagement.entity.Customer;
import com.harshal.orderManagement.mapper.customer.CustomerMapperImpl;
import com.harshal.orderManagement.service.CustomerService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Validated
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapperImpl customerMapper;

    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.getAllCustomers().stream().map(customerMapper::toDto).toList();
    }

    @PostMapping
    public CustomerResponseDto createCustomer(@RequestBody CreateCustomerDto dto) {
        Customer customer = customerMapper.fromDto(dto);
        return customerMapper.toDto(customerService.createCustomer(customer));
    }

    @GetMapping("/{customer_id}")
    public CustomerResponseDto getCustomerById(@PathVariable("customer_id") Long id) {
        return customerMapper.toDto(customerService.getCustomerById(id));
    }

    @PutMapping("/{customer_id}")
    public CustomerResponseDto updateCustomer(@RequestBody CreateCustomerDto dto, @PathVariable("customer_id") Long id) {
        Customer customer = customerMapper.fromDto(dto);
        return customerMapper.toDto(customerService.updateCustomer(customer, id));
    }

    @DeleteMapping("/{customer_id}")
    public void deleteCustomer(@PathVariable("customer_id") Long id) {
        customerService.deleteCustomer(id);
    }
}
