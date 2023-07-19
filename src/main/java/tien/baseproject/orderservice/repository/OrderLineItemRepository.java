package tien.baseproject.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tien.baseproject.orderservice.entity.OrderLineItems;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItems, Long> {
}
