package pl.motorola.customerjpa.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double sum;
    private LocalDateTime orderDate;
    @ManyToOne
    private Customer customer;


    public Order(Double sum, LocalDateTime orderDate, Customer customer) {
        this.sum = sum;
        this.orderDate = orderDate;
        this.customer = customer;
    }
}
