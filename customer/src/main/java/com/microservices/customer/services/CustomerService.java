package com.microservices.customer.services;

import com.microservices.customer.dto.CustomerRegistrationRequestDto;
import com.microservices.customer.dto.FraudCheckResponseDto;
import com.microservices.customer.repositories.CustomerRepository;
import com.microservices.customer.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequestDto customerRegistrationRequestDto) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequestDto.getFirstName())
                .lastName(customerRegistrationRequestDto.getLastName())
                .email(customerRegistrationRequestDto.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);
        FraudCheckResponseDto fraudCheckResponseDto = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponseDto.class,
                customer.getId()
        );

        if (fraudCheckResponseDto.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

    }
}
