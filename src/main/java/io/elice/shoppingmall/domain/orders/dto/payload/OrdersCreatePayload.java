package io.elice.shoppingmall.domain.orders.dto.payload;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrdersCreatePayload {
    private Long userId;

    private List<Long> cartId = new ArrayList<>();

    private String address;

    private String payment;

    private Long statusId;
}
