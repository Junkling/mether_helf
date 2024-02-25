package io.elice.shoppingmall.domain.orders.repository;

import io.elice.shoppingmall.domain.orders.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
}
