package io.elice.shoppingmall.domain.item.dto.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCreatePayload {
    @NotEmpty
    private Long secondCategoryId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String content;
    @NotEmpty
    private Integer price;

    private Integer stock;

    private Integer discountPer;
}
