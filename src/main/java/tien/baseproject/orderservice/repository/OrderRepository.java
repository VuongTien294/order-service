package tien.baseproject.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tien.baseproject.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
