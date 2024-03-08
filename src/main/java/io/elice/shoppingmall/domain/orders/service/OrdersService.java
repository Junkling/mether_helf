package io.elice.shoppingmall.domain.orders.service;
import io.elice.shoppingmall.domain.orders.dto.payload.*;
import io.elice.shoppingmall.domain.orders.dto.result.OrdersResult;

import java.util.List;
public interface OrdersService {

    Long saveOrder(OrdersCreatePayload payload);

    //List<OrdersResult> findOrders(Long userId);

    List<OrdersResult> findOrders();

    OrdersResult findOrder(Long id);

    Long updateOrder(Long id, OrdersUpdatePayload payload);

    Long deleteOrder(Long id);

}
