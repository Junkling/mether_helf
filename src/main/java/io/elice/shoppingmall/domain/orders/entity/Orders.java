package io.elice.shoppingmall.domain.orders.entity;

import io.elice.shoppingmall.common.BassEntity;
import io.elice.shoppingmall.domain.bill.entity.Bill;
import io.elice.shoppingmall.domain.delivery.entity.Delivery;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import io.elice.shoppingmall.domain.user.entity.User;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusCode statusCode;

    private Long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(mappedBy = "orders")
    private Delivery delivery;

    @OneToOne(mappedBy = "orders")
    private Bill bill;

    private String payment;

}
