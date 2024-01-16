package com.microservices.fraud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FraudCheckResponseDto {
    private Boolean isFraudster;
}
