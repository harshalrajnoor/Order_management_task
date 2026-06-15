package com.harshal.orderManagement.mapper.customer;

import com.harshal.orderManagement.dto.customer.CreateCustomerDto;
import com.harshal.orderManagement.dto.customer.CustomerResponseDto;
import com.harshal.orderManagement.entity.Customer;

public interface CustomerMapper {
    Customer fromDto(CreateCustomerDto dto);
    CustomerResponseDto toDto(Customer customer);

}
