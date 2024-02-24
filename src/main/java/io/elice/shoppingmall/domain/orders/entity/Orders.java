package io.elice.shoppingmall.domain.orders.entity;

import io.elice.shoppingmall.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Orders extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    private String title;
    private String orders_status;

    private Long amount;
    private Long user_id;
    private Long delivery_id;
    private Long bill_id;

    private String payment;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
