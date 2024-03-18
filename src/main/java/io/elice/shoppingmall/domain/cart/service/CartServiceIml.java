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
        User user = userRepository.findById(payload.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. userId=" + payload.getUserId()));
        Item item = itemRepository.findById(payload.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. itemId=" + payload.getItemId()));
        Cart saved = cartRepository.save(
                Cart.builder()
                        .user(user)
                        .item(item)
                        .count(payload.getCount())
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
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 장바구니가 없습니다. id=" + id));
        CartResult dto = cartResultMapper.toDto(cart);
        return dto;
    }

    @Transactional
    @Override
    public Long updateCart(Long id, CartUpdatePayload payload) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 장바구니가 없습니다. id=" + id));
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
