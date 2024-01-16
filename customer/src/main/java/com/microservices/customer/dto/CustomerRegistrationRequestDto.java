package com.microservices.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CustomerRegistrationRequestDto {
    private String firstName;
    private String lastName;
    private String email;
}
