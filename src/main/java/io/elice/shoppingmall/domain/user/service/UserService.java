package io.elice.shoppingmall.domain.user.service;

import io.elice.shoppingmall.domain.user.dto.payload.*;
import io.elice.shoppingmall.domain.user.dto.result.UserResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Long save(SignUpPayload payload);
    Long updateUser(Long userId , UserUpdatePayload payload);

    Page<UserResult> findAllUserByPage(String nickname , String role ,Pageable pageable);
    String signIn(SignInPayload payload);

    Boolean checkDuplicate(DuplicateCheckDto dto);

    UserResult findOneById(Long id);

    Long updateUserRole(Long userId, UserRoleEditPayload payload);
}
