package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.user.entity.User;
import io.elice.shoppingmall.domain.user.dto.result.UserResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResultMapper extends EntityMapper<UserResult,User>{
}
