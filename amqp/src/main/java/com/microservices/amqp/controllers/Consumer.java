package com.microservices.amqp.controllers;

import com.microservices.amqp.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "queue.First")
    public void receiveFromA(Message message) {
        log.info("message received from Queue First->{}", message);
    }

    @RabbitListener(queues = "queue.Second")
    public void receiveFromB(Message message) {
        log.info("message received from Queue Second->{}", message);
    }
}