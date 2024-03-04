package io.elice.shoppingmall.domain.delivery.dto.result;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryResult {
    private Long id;
    private Long orderId;
    private String address;
}
