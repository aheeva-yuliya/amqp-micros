package com.microservices.customer.controllers;

import com.microservices.customer.dto.CustomerRegistrationRequestDto;
import com.microservices.customer.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequestDto customerRequestDto) {
        log.info("new customer registration{}", customerRequestDto);
        customerService.registerCustomer(customerRequestDto);
    }
}
