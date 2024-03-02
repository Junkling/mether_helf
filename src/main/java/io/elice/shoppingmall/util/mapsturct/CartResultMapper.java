package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.cart.dto.result.CartResult;
import io.elice.shoppingmall.domain.cart.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartResultMapper extends EntityMapper<CartResult, Cart>{
}
