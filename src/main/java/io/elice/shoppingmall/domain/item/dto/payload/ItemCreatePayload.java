package io.elice.shoppingmall.domain.item.dto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCreatePayload {
    private Long middleCategoryId;

    private String name;

    private Integer price;

    private Integer stock;

    private Integer sellCount;

    private Integer discountPer;
}
