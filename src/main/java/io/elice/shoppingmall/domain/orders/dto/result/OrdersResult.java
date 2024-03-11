package io.elice.shoppingmall.domain.orders.dto.result;

import io.elice.shoppingmall.domain.delivery.dto.result.DeliveryResult;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrdersResult {
    private Long id;

    private String title;

    private String payment;

//    private String address;
//
//    private String deliveryStatus;

    private DeliveryResult delivery;

    private Long amount;

    private List<OrderItemResult> orderItemList = new ArrayList<>();

}
