package kz.springbootkafka.orderprocessor.repository;

import kz.springbootkafka.orderprocessor.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
