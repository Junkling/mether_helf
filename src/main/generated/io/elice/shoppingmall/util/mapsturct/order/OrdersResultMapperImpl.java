package io.elice.shoppingmall.util.mapsturct.order;

import io.elice.shoppingmall.domain.delivery.dto.result.DeliveryResult;
import io.elice.shoppingmall.domain.delivery.entity.Delivery;
import io.elice.shoppingmall.domain.orderitem.entity.OrderItem;
import io.elice.shoppingmall.domain.orders.dto.result.OrderItemResult;
import io.elice.shoppingmall.domain.orders.dto.result.OrdersResult;
import io.elice.shoppingmall.domain.orders.entity.Orders;
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
public class OrdersResultMapperImpl implements OrdersResultMapper {

    @Override
    public OrdersResult toDto(Orders entity) {
        if ( entity == null ) {
            return null;
        }

        OrdersResult ordersResult = new OrdersResult();

        ordersResult.setId( entity.getId() );
        ordersResult.setTitle( entity.getTitle() );
        ordersResult.setPayment( entity.getPayment() );
        ordersResult.setDelivery( deliveryToDeliveryResult( entity.getDelivery() ) );
        ordersResult.setAmount( entity.getAmount() );
        ordersResult.setOrderItemList( orderItemListToOrderItemResultList( entity.getOrderItemList() ) );

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

    protected DeliveryResult deliveryToDeliveryResult(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryResult deliveryResult = new DeliveryResult();

        deliveryResult.setId( delivery.getId() );
        deliveryResult.setAddress( delivery.getAddress() );
        deliveryResult.setStatusName( delivery.getStatusName() );

        return deliveryResult;
    }

    protected OrderItemResult orderItemToOrderItemResult(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemResult orderItemResult = new OrderItemResult();

        orderItemResult.setId( orderItem.getId() );
        orderItemResult.setItemName( orderItem.getItemName() );
        orderItemResult.setItemPrice( orderItem.getItemPrice() );
        orderItemResult.setCount( orderItem.getCount() );
        orderItemResult.setAmount( orderItem.getAmount() );

        return orderItemResult;
    }

    protected List<OrderItemResult> orderItemListToOrderItemResultList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemResult> list1 = new ArrayList<OrderItemResult>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemResult( orderItem ) );
        }

        return list1;
    }
}
