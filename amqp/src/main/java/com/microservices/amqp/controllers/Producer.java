package com.microservices.amqp.controllers;

import com.microservices.amqp.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Producer {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;

    @PostMapping("/api/v1/messages")
    public String send(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "routing.First", message);
        return "Message sent successfully";
    }
}
