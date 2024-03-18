package io.elice.shoppingmall.domain.item.dto.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCartResult {
    private Long id;

    private String name;

    private String content;

    private Integer price;

    private Integer discountPer;
}
