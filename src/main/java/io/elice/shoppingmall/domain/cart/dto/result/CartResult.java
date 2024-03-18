package io.elice.shoppingmall.domain.cart.dto.result;

import io.elice.shoppingmall.domain.item.dto.result.ItemCartResult;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CartResult {
    private Long id;
    private ItemCartResult item;
    private LocalDateTime createdDate;
    private Integer count;
}
