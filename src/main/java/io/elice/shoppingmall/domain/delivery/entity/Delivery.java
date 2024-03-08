package io.elice.shoppingmall.domain.delivery.entity;

import io.elice.shoppingmall.domain.common.BassEntity;
import io.elice.shoppingmall.domain.delivery.dto.payload.DeliveryUpdatePayload;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Delivery extends BassEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Orders orders;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusCode statusCode;

    public void updateDelivery(String address, StatusCode statusCode) {
        this.address = address;
        this.statusCode = statusCode;
    }

}
