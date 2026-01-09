package kz.springbootkafka.orderapi.producer;

import kz.springbootkafka.common.dto.OrderEventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderEventDTO> kafkaTemplate;

    public void sendOrder(OrderEventDTO event) {
        kafkaTemplate.send("order.created", event.getOrderId(), event);
    }
}