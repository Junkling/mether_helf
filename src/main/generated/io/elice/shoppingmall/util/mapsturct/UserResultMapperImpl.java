package io.elice.shoppingmall.util.mapsturct;

import io.elice.shoppingmall.domain.user.dto.result.UserResult;
import io.elice.shoppingmall.domain.user.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2024-02-29T15:11:41+0900",
=======
    date = "2024-02-27T15:20:13+0900",
>>>>>>> 7916880b2f44244caf90d961c7f6d9aada4a5827
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

        userResult.setNickname( entity.getNickname() );
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
