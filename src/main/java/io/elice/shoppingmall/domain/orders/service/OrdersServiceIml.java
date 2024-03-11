package io.elice.shoppingmall.domain.orders.service;

import io.elice.shoppingmall.domain.bill.repository.BillRepository;
import io.elice.shoppingmall.domain.cart.entity.Cart;
import io.elice.shoppingmall.domain.cart.repository.CartRepository;
import io.elice.shoppingmall.domain.delivery.entity.Delivery;
import io.elice.shoppingmall.domain.delivery.repository.DeliveryRepository;
import io.elice.shoppingmall.domain.orderitem.entity.OrderItem;
import io.elice.shoppingmall.domain.orderitem.repository.OrderItemRepository;
import io.elice.shoppingmall.domain.orders.dto.payload.*;
import io.elice.shoppingmall.domain.orders.dto.result.OrdersResult;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import io.elice.shoppingmall.domain.orders.repository.OrdersRepository;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import io.elice.shoppingmall.domain.statuscode.repository.StatusCodeRepository;
import io.elice.shoppingmall.domain.user.entity.User;
import io.elice.shoppingmall.domain.user.repository.UserRepository;
import io.elice.shoppingmall.util.mapsturct.order.OrdersResultMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceIml implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final StatusCodeRepository statusCodeRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartRepository cartRepository;
    private final BillRepository billRepository;
    private final DeliveryRepository deliveryRepository;
    private final OrdersResultMapper ordersResultMapper;

    @Transactional
    @Override
    public Long saveOrder(OrdersCreatePayload payload) {
        User user = userRepository.findById(payload.getUserId()).orElseThrow();
        Orders saved = ordersRepository.save(Orders.builder()
                .user(user)
                .payment(payload.getPayment())
                .amount(0L)
                .statusCode(statusCodeRepository.findById(payload.getStatusId()).orElseThrow())
                .build());
        deliveryRepository.save(Delivery.builder().address(payload.getAddress()).orders(saved).build());

        List<Cart> cartList = payload.getCartId().stream().map(c -> cartRepository.findById(c).orElseThrow()).toList();
        saved.setTitleName(cartList);

//        Bill.builder(). 어쩌구 저쩌구 Delivery랑 똑같이 저장
        cartList.forEach(e -> {
                    Integer amount = e.getCount() * (e.getItem().getPrice() - (int) Math.ceil(((double) (e.getItem().getPrice() * e.getItem().getDiscountPer()) / 100)));
                    orderItemRepository.save(
                            OrderItem.builder()
                                    .orders(saved)
                                    .item(e.getItem())
                                    .count(e.getCount())
                                    .itemPrice(e.getItem().getPrice())
                                    .itemName(e.getItem().getName())
                                    .amount(amount)
                                    .build());
                    saved.increaseAmount(amount);
                }
        );

        payload.getCartId().forEach(cartRepository::deleteById);

        return saved.getId();
    }

    @Override
    public Page<OrdersResult> findOrders(Long userId, Pageable pageable) {
        if (userId != null && userId != 0) {
            return ordersRepository.findAllByUserId(userId, pageable).map(ordersResultMapper::toDto);
        }
        return ordersRepository.findAll(pageable).map(ordersResultMapper::toDto);
    }

//    @Override
//    public List<OrdersResult> findOrders(Long userId){
//        List<Orders> ordersList = ordersRepository.findByUserId(userId);
//        List<OrdersResult> dtoList = ordersResultMapper.toDtoList(ordersList);
//        return dtoList;
//    }

    @Override
    public OrdersResult findOrder(Long id) {
        Orders orders = ordersRepository.findById(id).orElseThrow();
        OrdersResult dto = ordersResultMapper.toDto(orders);
        return dto;
    }

    @Transactional
    @Override
    public Long updateOrder(Long id, OrdersUpdatePayload payload) {
        StatusCode statusCode = statusCodeRepository.findById(payload.getOrdersStatus()).orElseThrow();
        Orders orders = ordersRepository.findById(id).orElseThrow();
        orders.updateOrders(statusCode);
        return orders.getId();
    }

    @Transactional
    @Override
    public Long deleteOrder(Long id) {
        ordersRepository.deleteById(id);
        return id;
    }


}
