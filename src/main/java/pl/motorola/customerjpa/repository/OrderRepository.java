package pl.motorola.customerjpa.repository;

import org.springframework.data.repository.CrudRepository;
import pl.motorola.customerjpa.entity.Order;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
