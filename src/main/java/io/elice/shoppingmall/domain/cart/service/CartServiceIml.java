package io.elice.shoppingmall.domain.cart.service;

import io.elice.shoppingmall.domain.cart.dto.payload.CartCreatePayload;
import io.elice.shoppingmall.domain.cart.dto.payload.CartUpdatePayload;
import io.elice.shoppingmall.domain.cart.dto.result.CartResult;
import io.elice.shoppingmall.domain.cart.entity.Cart;
import io.elice.shoppingmall.domain.cart.repository.CartRepository;
import io.elice.shoppingmall.domain.item.entity.Item;
import io.elice.shoppingmall.domain.item.repository.ItemRepository;
import io.elice.shoppingmall.domain.user.entity.User;
import io.elice.shoppingmall.domain.user.repository.UserRepository;
import io.elice.shoppingmall.util.mapsturct.CartResultMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceIml implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final CartResultMapper cartResultMapper;

    @Transactional
    @Override
    public Long saveCart(CartCreatePayload payload) {
        User user = userRepository.findById(payload.getUserId()).orElseThrow();
        Item item = itemRepository.findById(payload.getItemId()).orElseThrow();
        Cart saved = cartRepository.save(
                Cart.builder()
                        .user(user)
                        .item(item)
                        .build());
        return saved.getId();
    }

    @Override
    public List<CartResult> findCarts(Long userId) {
        List<Cart> cartList = cartRepository.findAllByUserId(userId);
        List<CartResult> dtoList = cartResultMapper.toDtoList(cartList);
        return dtoList;
    }

    @Override
    public CartResult findCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        CartResult dto = cartResultMapper.toDto(cart);
        return dto;
    }

    @Transactional
    @Override
    public Long updateCart(Long id, CartUpdatePayload payload) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.updateCart(payload.getCount());
        return cart.getId();
    }

    @Transactional
    @Override
    public Long deleteCart(Long id) {
        cartRepository.deleteById(id);
        return id;
    }

    // 장바구니 전체 삭제
    @Transactional
    @Override
    public void deleteAllCart(Long userId) {
        List<Cart> allByUserId = cartRepository.findAllByUserId(userId);
        cartRepository.deleteAll(allByUserId);
    }


}
