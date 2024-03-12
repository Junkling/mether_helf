package io.elice.shoppingmall.domain.item.dto.result;

import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDetailResult {
    private Long id;

    private SecondCategoryResult secondCategory;

    private String name;

    private String content;

    private Integer price;

    private Integer stock;

    private Integer discountPer;
}
