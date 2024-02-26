package io.elice.shoppingmall.domain.user.service;

import io.elice.shoppingmall.domain.user.dto.payload.SignInPayload;
import io.elice.shoppingmall.domain.user.dto.payload.SignUpPayload;
import io.elice.shoppingmall.domain.user.dto.payload.UserEditPayload;

public interface UserService {
    Long save(SignUpPayload payload);
    Long updateUser(UserEditPayload payload);

    String signIn(SignInPayload payload);

    Boolean duplicateIdCheck(String payload);
    Boolean duplicateEmailCheck(String payload);
    Boolean duplicateNicknameCheck(String payload);

}
