package io.elice.shoppingmall.util.mapsturct.order;

import io.elice.shoppingmall.domain.orderitem.entity.OrderItem;
import io.elice.shoppingmall.domain.orders.dto.result.OrderItemResult;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-15T00:26:24+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderItemResultMapperImpl implements OrderItemResultMapper {

    @Override
    public OrderItemResult toDto(OrderItem entity) {
        if ( entity == null ) {
            return null;
        }

        OrderItemResult orderItemResult = new OrderItemResult();

        orderItemResult.setId( entity.getId() );
        orderItemResult.setItemName( entity.getItemName() );
        orderItemResult.setItemPrice( entity.getItemPrice() );
        orderItemResult.setCount( entity.getCount() );
        orderItemResult.setAmount( entity.getAmount() );

        return orderItemResult;
    }

    @Override
    public List<OrderItemResult> toDtoList(List<OrderItem> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderItemResult> list = new ArrayList<OrderItemResult>( entities.size() );
        for ( OrderItem orderItem : entities ) {
            list.add( toDto( orderItem ) );
        }

        return list;
    }
}
