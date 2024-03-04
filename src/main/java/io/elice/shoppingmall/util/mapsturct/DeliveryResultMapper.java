package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.delivery.dto.result.DeliveryResult;
import io.elice.shoppingmall.domain.delivery.entity.Delivery;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DeliveryResultMapper extends EntityMapper<DeliveryResult, Delivery>{
}
