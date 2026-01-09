package kz.springbootkafka.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDTO {
    private String orderId;
    private String product;
    private int quantity;
    private BigDecimal price;
}