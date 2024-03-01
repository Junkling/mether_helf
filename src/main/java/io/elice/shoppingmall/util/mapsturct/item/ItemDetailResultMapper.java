package io.elice.shoppingmall.util.mapsturct.item;

import io.elice.shoppingmall.domain.item.dto.result.ItemDetailResult;
import io.elice.shoppingmall.domain.item.entity.Item;
import io.elice.shoppingmall.util.mapsturct.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemDetailResultMapper extends EntityMapper<ItemDetailResult, Item> {
}
