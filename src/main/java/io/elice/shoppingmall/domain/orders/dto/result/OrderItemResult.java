package io.elice.shoppingmall.domain.orders.dto.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResult {
    private Long id;
    private String itemName;
    private Integer itemPrice;
    private Integer count;
    private Integer amount;
}
