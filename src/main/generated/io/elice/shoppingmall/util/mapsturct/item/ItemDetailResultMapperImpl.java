package io.elice.shoppingmall.util.mapsturct.item;

import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryResult;
import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import io.elice.shoppingmall.domain.category.entity.SecondCategory;
import io.elice.shoppingmall.domain.item.dto.result.ItemDetailResult;
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
public class ItemDetailResultMapperImpl implements ItemDetailResultMapper {

    @Override
    public ItemDetailResult toDto(Item entity) {
        if ( entity == null ) {
            return null;
        }

        ItemDetailResult itemDetailResult = new ItemDetailResult();

        itemDetailResult.setId( entity.getId() );
        itemDetailResult.setSecondCategory( secondCategoryToSecondCategoryResult( entity.getSecondCategory() ) );
        itemDetailResult.setName( entity.getName() );
        itemDetailResult.setContent( entity.getContent() );
        itemDetailResult.setPrice( entity.getPrice() );
        itemDetailResult.setStock( entity.getStock() );
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

    protected FirstCategoryResult firstCategoryToFirstCategoryResult(FirstCategory firstCategory) {
        if ( firstCategory == null ) {
            return null;
        }

        FirstCategoryResult firstCategoryResult = new FirstCategoryResult();

        firstCategoryResult.setId( firstCategory.getId() );
        firstCategoryResult.setName( firstCategory.getName() );
        firstCategoryResult.setRole( firstCategory.getRole() );

        return firstCategoryResult;
    }

    protected SecondCategoryResult secondCategoryToSecondCategoryResult(SecondCategory secondCategory) {
        if ( secondCategory == null ) {
            return null;
        }

        SecondCategoryResult secondCategoryResult = new SecondCategoryResult();

        secondCategoryResult.setId( secondCategory.getId() );
        secondCategoryResult.setName( secondCategory.getName() );
        secondCategoryResult.setFirstCategory( firstCategoryToFirstCategoryResult( secondCategory.getFirstCategory() ) );

        return secondCategoryResult;
    }
}
