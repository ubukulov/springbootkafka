package kz.springbootkafka.orderprocessor.consumer;

import kz.springbootkafka.orderprocessor.repository.OrderRepository;
import kz.springbootkafka.orderprocessor.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import kz.springbootkafka.common.dto.OrderEventDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderConsumer {

    private final OrderRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(
            topics = "order.created",
            groupId = "order-processor-group"
    )
    public void consume(OrderEventDTO event) {

        log.info("Received order: {}", event);

        try {
            Order order = new Order();
            order.setOrderId(event.getOrderId());
            order.setProduct(event.getProduct());
            order.setQuantity(event.getQuantity());
            order.setPrice(event.getPrice());
            order.setStatus("PROCESSED");

            repository.save(order);

            kafkaTemplate.send("order.processed", event.getOrderId(), event);

        } catch (Exception e) {
            log.error("Order processing failed", e);
            kafkaTemplate.send("order.failed", event.getOrderId(), event);
        }
    }
}