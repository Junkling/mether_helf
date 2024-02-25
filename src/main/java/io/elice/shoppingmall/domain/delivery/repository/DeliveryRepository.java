package io.elice.shoppingmall.domain.delivery.repository;

import io.elice.shoppingmall.domain.delivery.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
