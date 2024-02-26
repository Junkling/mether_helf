package io.elice.shoppingmall.domain.bill.entity;

import io.elice.shoppingmall.domain.common.BassEntity;
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
    private Integer account;
    private String depositorName;

    private Integer amount;

    @OneToOne
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusCode statusCode;


}
