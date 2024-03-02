package io.elice.shoppingmall.domain.cart.dto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartCreatePayload {
    private Long userId;
    private Long itemId;
}
