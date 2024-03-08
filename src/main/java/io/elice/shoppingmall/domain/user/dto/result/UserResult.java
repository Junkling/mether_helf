package io.elice.shoppingmall.domain.user.dto.result;

import lombok.Data;

@Data
public class UserResult {
    private Long id;
    private String nickname;
    private String role;
    private String email;
}
