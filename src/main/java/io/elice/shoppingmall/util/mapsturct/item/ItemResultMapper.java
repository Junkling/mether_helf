package io.elice.shoppingmall.util.mapsturct.item;

import io.elice.shoppingmall.domain.item.dto.result.ItemResult;
import io.elice.shoppingmall.domain.item.entity.Item;
import io.elice.shoppingmall.util.mapsturct.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemResultMapper extends EntityMapper<ItemResult, Item> {
}
