package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.bill.dto.result.BillResult;
import io.elice.shoppingmall.domain.bill.entity.Bill;
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
public class BillResultMapperImpl implements BillResultMapper {

    @Override
    public BillResult toDto(Bill entity) {
        if ( entity == null ) {
            return null;
        }

        BillResult billResult = new BillResult();

        return billResult;
    }

    @Override
    public List<BillResult> toDtoList(List<Bill> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BillResult> list = new ArrayList<BillResult>( entities.size() );
        for ( Bill bill : entities ) {
            list.add( toDto( bill ) );
        }

        return list;
    }
}
