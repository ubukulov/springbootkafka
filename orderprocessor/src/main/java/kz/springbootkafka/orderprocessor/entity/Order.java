package kz.springbootkafka.orderprocessor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Data
@Getter
@Setter
public class Order {

    @jakarta.persistence.Id
    @Id
    private Long id;

    private String orderId;

    private String product;
    private int quantity;
    private BigDecimal price;

    private String status;
}
