package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.cart.dto.result.CartResult;
import io.elice.shoppingmall.domain.cart.entity.Cart;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T17:59:05+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CartResultMapperImpl implements CartResultMapper {

    @Override
    public CartResult toDto(Cart arg0) {
        if ( arg0 == null ) {
            return null;
        }

        CartResult cartResult = new CartResult();

        cartResult.setId( arg0.getId() );

        return cartResult;
    }

    @Override
    public List<CartResult> toDtoList(List<Cart> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<CartResult> list = new ArrayList<CartResult>( arg0.size() );
        for ( Cart cart : arg0 ) {
            list.add( toDto( cart ) );
        }

        return list;
    }
}
