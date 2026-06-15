package com.harshal.orderManagement.mapper.customer;

import com.harshal.orderManagement.dto.customer.CreateCustomerDto;
import com.harshal.orderManagement.dto.customer.CustomerResponseDto;
import com.harshal.orderManagement.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer fromDto(CreateCustomerDto dto) {
        return Customer.builder()
                .name(dto.name())
                .email(dto.email())
                .phoneNumber(dto.phoneNumber())
                .address(dto.address())
                .build();
    }

    @Override
    public CustomerResponseDto toDto(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNo(customer.getPhoneNumber())
                .address(customer.getAddress())
                .build();
    }
}
