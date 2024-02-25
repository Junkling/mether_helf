package io.elice.shoppingmall.domain.orderitem.repository;

import io.elice.shoppingmall.domain.orderitem.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
