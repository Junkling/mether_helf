package io.elice.shoppingmall.util.mapsturct.category;

import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import io.elice.shoppingmall.domain.category.entity.SecondCategory;
import io.elice.shoppingmall.util.mapsturct.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SecondCategoryResultMapper extends EntityMapper<SecondCategoryResult, SecondCategory> {
}
