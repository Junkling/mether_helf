package io.elice.shoppingmall.domain.orderitem.entity;

import io.elice.shoppingmall.common.BassEntity;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderItem extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long item_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Orders orders;

    private Integer count;
    private Long amount;
}
