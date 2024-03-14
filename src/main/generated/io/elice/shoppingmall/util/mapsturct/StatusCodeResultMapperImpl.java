package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.statuscode.dto.result.StatusCodeResult;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
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
public class StatusCodeResultMapperImpl implements StatusCodeResultMapper {

    @Override
    public StatusCodeResult toDto(StatusCode entity) {
        if ( entity == null ) {
            return null;
        }

        StatusCodeResult statusCodeResult = new StatusCodeResult();

        statusCodeResult.setId( entity.getId() );
        statusCodeResult.setName( entity.getName() );

        return statusCodeResult;
    }

    @Override
    public List<StatusCodeResult> toDtoList(List<StatusCode> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StatusCodeResult> list = new ArrayList<StatusCodeResult>( entities.size() );
        for ( StatusCode statusCode : entities ) {
            list.add( toDto( statusCode ) );
        }

        return list;
    }
}
