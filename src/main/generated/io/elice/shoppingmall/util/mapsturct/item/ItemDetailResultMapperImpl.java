package io.elice.shoppingmall.util.mapsturct.item;

import io.elice.shoppingmall.domain.item.dto.result.ItemDetailResult;
import io.elice.shoppingmall.domain.item.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T15:02:46+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ItemDetailResultMapperImpl implements ItemDetailResultMapper {

    @Override
    public ItemDetailResult toDto(Item entity) {
        if ( entity == null ) {
            return null;
        }

        ItemDetailResult itemDetailResult = new ItemDetailResult();

        itemDetailResult.setId( entity.getId() );
        itemDetailResult.setName( entity.getName() );
        itemDetailResult.setContent( entity.getContent() );
        itemDetailResult.setPrice( entity.getPrice() );
        itemDetailResult.setStock( entity.getStock() );
        itemDetailResult.setSellCount( entity.getSellCount() );
        itemDetailResult.setDiscountPer( entity.getDiscountPer() );

        return itemDetailResult;
    }

    @Override
    public List<ItemDetailResult> toDtoList(List<Item> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ItemDetailResult> list = new ArrayList<ItemDetailResult>( entities.size() );
        for ( Item item : entities ) {
            list.add( toDto( item ) );
        }

        return list;
    }
}
