package io.elice.shoppingmall.domain.cart.dto.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartCreatePayload {
    private Long userId;
    @NotNull
    private Long itemId;
    @NotNull
    private Integer count;
}
