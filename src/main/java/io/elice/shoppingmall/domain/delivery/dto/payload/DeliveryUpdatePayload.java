package io.elice.shoppingmall.domain.delivery.dto.payload;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryUpdatePayload {
    private Long id;
    private Long orderId;
    private String address;
}
