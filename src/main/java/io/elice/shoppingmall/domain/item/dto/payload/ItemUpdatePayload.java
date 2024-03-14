package io.elice.shoppingmall.domain.item.dto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemUpdatePayload {

    private String name;

    private String content;

    private Integer price;

    private Integer stock;

    private Integer discountPer;

}
