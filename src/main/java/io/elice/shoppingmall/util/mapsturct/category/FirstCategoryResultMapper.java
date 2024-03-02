package io.elice.shoppingmall.util.mapsturct.category;

import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryResult;
import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import io.elice.shoppingmall.util.mapsturct.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FirstCategoryResultMapper extends EntityMapper<FirstCategoryResult, FirstCategory> {

}
