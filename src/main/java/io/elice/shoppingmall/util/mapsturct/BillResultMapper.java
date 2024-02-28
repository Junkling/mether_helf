package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.bill.dto.result.BillResult;
import io.elice.shoppingmall.domain.bill.entity.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillResultMapper extends EntityMapper<BillResult, Bill>{
}
