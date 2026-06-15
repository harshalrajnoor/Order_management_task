package com.harshal.orderManagement.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateCustomerDto(
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Phone Number is required") String phoneNumber,
        @NotBlank(message = "Email is required") @Email String email,
        @NotBlank(message = "Address is required") String address
) {
}
