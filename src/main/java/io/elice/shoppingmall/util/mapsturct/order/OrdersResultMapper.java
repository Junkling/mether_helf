package io.elice.shoppingmall.util.mapsturct.order;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import io.elice.shoppingmall.domain.orders.dto.result.OrdersResult;
import io.elice.shoppingmall.util.mapsturct.EntityMapper;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface OrdersResultMapper extends EntityMapper<OrdersResult, Orders> {
}
