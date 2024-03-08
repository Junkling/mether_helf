package io.elice.shoppingmall.domain.orders.dto.payload;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersUpdatePayload {
    private Long orderId;
    private Long ordersStatus;
}
