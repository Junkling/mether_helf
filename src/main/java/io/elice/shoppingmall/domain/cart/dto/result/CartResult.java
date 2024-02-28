package io.elice.shoppingmall.domain.cart.dto.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResult {
    private Long id;
    private Long userId;
    private Long itemId;
}
