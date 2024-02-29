package io.elice.shoppingmall.util.mapsturct.category;

import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import io.elice.shoppingmall.domain.category.entity.SecondCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T16:28:31+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class SecondCategoryResultMapperImpl implements SecondCategoryResultMapper {

    @Override
    public SecondCategoryResult toDto(SecondCategory entity) {
        if ( entity == null ) {
            return null;
        }

        SecondCategoryResult secondCategoryResult = new SecondCategoryResult();

        secondCategoryResult.setId( entity.getId() );
        secondCategoryResult.setName( entity.getName() );

        return secondCategoryResult;
    }

    @Override
    public List<SecondCategoryResult> toDtoList(List<SecondCategory> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SecondCategoryResult> list = new ArrayList<SecondCategoryResult>( entities.size() );
        for ( SecondCategory secondCategory : entities ) {
            list.add( toDto( secondCategory ) );
        }

        return list;
    }
}
