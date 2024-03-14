package io.elice.shoppingmall.util.mapsturct.category;

import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryResult;
import io.elice.shoppingmall.domain.category.entity.FirstCategory;
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
public class FirstCategoryResultMapperImpl implements FirstCategoryResultMapper {

    @Override
    public FirstCategoryResult toDto(FirstCategory entity) {
        if ( entity == null ) {
            return null;
        }

        FirstCategoryResult firstCategoryResult = new FirstCategoryResult();

        firstCategoryResult.setId( entity.getId() );
        firstCategoryResult.setName( entity.getName() );
        firstCategoryResult.setRole( entity.getRole() );

        return firstCategoryResult;
    }

    @Override
    public List<FirstCategoryResult> toDtoList(List<FirstCategory> entities) {
        if ( entities == null ) {
            return null;
        }

        List<FirstCategoryResult> list = new ArrayList<FirstCategoryResult>( entities.size() );
        for ( FirstCategory firstCategory : entities ) {
            list.add( toDto( firstCategory ) );
        }

        return list;
    }
}
