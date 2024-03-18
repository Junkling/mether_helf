package io.elice.shoppingmall.domain.orders.service;
import io.elice.shoppingmall.domain.orders.dto.payload.*;
import io.elice.shoppingmall.domain.orders.dto.result.OrdersResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface OrdersService {

    Long saveOrder(OrdersCreatePayload payload);

    //List<OrdersResult> findOrders(Long userId);

    Page<OrdersResult> findOrders(Long userId , Pageable pageable);

    OrdersResult findOrder(Long id);

    Long updateOrder(Long id, OrdersUpdatePayload payload);

    Long deleteOrder(Long id);

}
