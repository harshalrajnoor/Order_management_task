package com.harshal.orderManagement.dto.customer;

import lombok.Builder;

@Builder
public record CustomerResponseDto(
        Long id,
        String name,
        String phoneNo,
        String email,
        String address

) {
}
