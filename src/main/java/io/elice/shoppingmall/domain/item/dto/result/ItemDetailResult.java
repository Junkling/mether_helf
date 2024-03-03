package io.elice.shoppingmall.domain.item.dto.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDetailResult {
    private Long id;

    private Long secondCategoryId;

    private String name;

    private Integer price;

    private Integer stock;

    private Integer sellCount;

    private Integer discountPer;
}
