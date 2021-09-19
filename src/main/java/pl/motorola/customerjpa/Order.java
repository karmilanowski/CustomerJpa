package pl.motorola.customerjpa;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal sum;
    private LocalDateTime orderDate;
    @ManyToOne
    private Customer customer;

    public Order(BigDecimal sum, LocalDateTime orderDate) {
        this.sum = sum;
        this.orderDate = orderDate;
    }
}
