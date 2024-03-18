package io.elice.shoppingmall.util.mapsturct.order;

import io.elice.shoppingmall.domain.orderitem.entity.OrderItem;
import io.elice.shoppingmall.domain.orders.dto.result.OrderItemResult;
import io.elice.shoppingmall.util.mapsturct.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemResultMapper extends EntityMapper<OrderItemResult, OrderItem> {
}
