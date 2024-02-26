package io.elice.shoppingmall.domain.user.dto.payload;

import lombok.Data;

@Data
public class SignInPayload {
    private String username;
    private String password;
}
