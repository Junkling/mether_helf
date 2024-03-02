package io.elice.shoppingmall.domain.item.dto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemUpdatePayload {
    private Long secondCategoryId;

    private String name;

    private Integer price;

    private Integer stock;

    private Integer sellCount;

    private Integer discountPer;

}
