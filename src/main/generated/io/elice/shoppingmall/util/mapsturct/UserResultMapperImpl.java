package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.user.dto.result.UserResult;
import io.elice.shoppingmall.domain.user.entity.User;
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
public class UserResultMapperImpl implements UserResultMapper {

    @Override
    public UserResult toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResult userResult = new UserResult();

        userResult.setId( entity.getId() );
        userResult.setNickname( entity.getNickname() );
        userResult.setRole( entity.getRole() );
        userResult.setEmail( entity.getEmail() );

        return userResult;
    }

    @Override
    public List<UserResult> toDtoList(List<User> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserResult> list = new ArrayList<UserResult>( entities.size() );
        for ( User user : entities ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
