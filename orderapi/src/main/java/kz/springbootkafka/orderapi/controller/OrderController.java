package kz.springbootkafka.orderapi.controller;

import kz.springbootkafka.common.dto.OrderEventDTO;
import kz.springbootkafka.orderapi.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer producer;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderEventDTO event) {

        if (event.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.badRequest().body("Price must be > 0");
        }

        producer.sendOrder(event);
        return ResponseEntity.ok("Order sent to Kafka");
    }
}