package io.elice.shoppingmall.domain.bill.entity;

import io.elice.shoppingmall.common.BassEntity;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Bill extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private Long account;
    private String depositorName;

    private Long amount;

    private Long ordersId;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusCode statusCode;


}
