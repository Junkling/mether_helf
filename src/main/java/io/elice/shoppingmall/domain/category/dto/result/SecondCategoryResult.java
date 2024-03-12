package io.elice.shoppingmall.domain.category.dto.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecondCategoryResult {

    private Long id;

    private String name;

    private FirstCategoryResult firstCategory;
}
