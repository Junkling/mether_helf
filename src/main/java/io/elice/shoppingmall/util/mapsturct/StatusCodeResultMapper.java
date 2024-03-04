package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.statuscode.dto.result.StatusCodeResult;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusCodeResultMapper extends EntityMapper<StatusCodeResult,StatusCode>{
}
