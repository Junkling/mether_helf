package io.elice.shoppingmall.domain.category.dto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecondCategoryUpdatePayload {
    private String name;
    private Long firstCategoryId;
}
