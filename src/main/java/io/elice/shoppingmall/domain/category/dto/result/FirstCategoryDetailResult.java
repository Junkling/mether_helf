package io.elice.shoppingmall.domain.category.dto.result;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FirstCategoryDetailResult extends FirstCategoryResult {
    List<SecondCategoryResult> secondCategoryList = new ArrayList<>();
}
