package io.elice.shoppingmall.domain.orderitem.entity;

import io.elice.shoppingmall.common.BassEntity;
import io.elice.shoppingmall.domain.item.entity.Item;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    private String itemName;
    private String itemPrice;
    private Integer count;
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Orders orders;

}
