package io.elice.shoppingmall.util.mapsturct.category;

import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryDetailResult;
import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import io.elice.shoppingmall.domain.category.entity.SecondCategory;
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
public class FirstCategoryDetailResultMapperImpl implements FirstCategoryDetailResultMapper {

    @Override
    public FirstCategoryDetailResult toDto(FirstCategory entity) {
        if ( entity == null ) {
            return null;
        }

        FirstCategoryDetailResult firstCategoryDetailResult = new FirstCategoryDetailResult();

        firstCategoryDetailResult.setId( entity.getId() );
        firstCategoryDetailResult.setName( entity.getName() );
        firstCategoryDetailResult.setRole( entity.getRole() );
        firstCategoryDetailResult.setSecondCategoryList( secondCategoryListToSecondCategoryResultList( entity.getSecondCategoryList() ) );

        return firstCategoryDetailResult;
    }

    @Override
    public List<FirstCategoryDetailResult> toDtoList(List<FirstCategory> entities) {
        if ( entities == null ) {
            return null;
        }

        List<FirstCategoryDetailResult> list = new ArrayList<FirstCategoryDetailResult>( entities.size() );
        for ( FirstCategory firstCategory : entities ) {
            list.add( toDto( firstCategory ) );
        }

        return list;
    }

    protected SecondCategoryResult secondCategoryToSecondCategoryResult(SecondCategory secondCategory) {
        if ( secondCategory == null ) {
            return null;
        }

        SecondCategoryResult secondCategoryResult = new SecondCategoryResult();

        secondCategoryResult.setId( secondCategory.getId() );
        secondCategoryResult.setName( secondCategory.getName() );
        secondCategoryResult.setFirstCategory( toDto( secondCategory.getFirstCategory() ) );

        return secondCategoryResult;
    }

    protected List<SecondCategoryResult> secondCategoryListToSecondCategoryResultList(List<SecondCategory> list) {
        if ( list == null ) {
            return null;
        }

        List<SecondCategoryResult> list1 = new ArrayList<SecondCategoryResult>( list.size() );
        for ( SecondCategory secondCategory : list ) {
            list1.add( secondCategoryToSecondCategoryResult( secondCategory ) );
        }

        return list1;
    }
}
