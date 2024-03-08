package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.orders.dto.result.OrdersResult;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-04T17:40:33+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class OrdersResultMapperImpl implements OrdersResultMapper {

    @Override
    public OrdersResult toDto(Orders entity) {
        if ( entity == null ) {
            return null;
        }

        OrdersResult ordersResult = new OrdersResult();

        return ordersResult;
    }

    @Override
    public List<OrdersResult> toDtoList(List<Orders> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrdersResult> list = new ArrayList<OrdersResult>( entities.size() );
        for ( Orders orders : entities ) {
            list.add( toDto( orders ) );
        }

        return list;
    }
}
