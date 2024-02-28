package io.elice.shoppingmall.domain.cart.service;

import io.elice.shoppingmall.domain.cart.dto.payload.CartCreatePayload;
import io.elice.shoppingmall.domain.cart.dto.payload.CartUpdatePayload;
import io.elice.shoppingmall.domain.cart.dto.result.CartResult;

import java.util.List;

public interface CartService {

    // crud
    Long saveCart(CartCreatePayload payload);

    List<CartResult> findCarts(Long userId);

    CartResult findCart(Long id);

    Long updateCart(Long id, CartUpdatePayload payload);

    Long deleteCart(Long id);

}
