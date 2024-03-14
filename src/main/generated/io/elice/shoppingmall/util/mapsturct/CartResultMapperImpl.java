package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.cart.dto.result.CartResult;
import io.elice.shoppingmall.domain.cart.entity.Cart;
import io.elice.shoppingmall.domain.item.dto.result.ItemCartResult;
import io.elice.shoppingmall.domain.item.entity.Item;
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
public class CartResultMapperImpl implements CartResultMapper {

    @Override
    public CartResult toDto(Cart entity) {
        if ( entity == null ) {
            return null;
        }

        CartResult cartResult = new CartResult();

        cartResult.setId( entity.getId() );
        cartResult.setItem( itemToItemCartResult( entity.getItem() ) );
        cartResult.setCreatedDate( entity.getCreatedDate() );
        cartResult.setCount( entity.getCount() );

        return cartResult;
    }

    @Override
    public List<CartResult> toDtoList(List<Cart> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CartResult> list = new ArrayList<CartResult>( entities.size() );
        for ( Cart cart : entities ) {
            list.add( toDto( cart ) );
        }

        return list;
    }

    protected ItemCartResult itemToItemCartResult(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemCartResult itemCartResult = new ItemCartResult();

        itemCartResult.setId( item.getId() );
        itemCartResult.setName( item.getName() );
        itemCartResult.setContent( item.getContent() );
        itemCartResult.setPrice( item.getPrice() );
        itemCartResult.setDiscountPer( item.getDiscountPer() );

        return itemCartResult;
    }
}
