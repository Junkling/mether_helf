package io.elice.shoppingmall.domain.orders.dto.payload;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersCreatePayload {
    private Long orderId;
    private Long userId;
}
