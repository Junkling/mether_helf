package io.elice.shoppingmall.domain.orderitem.entity;

import io.elice.shoppingmall.common.BassEntity;
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
    private Long orders_id;

    private Long count;
    private Long amount;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
