package io.elice.shoppingmall.web.payload.user;

import lombok.Data;

@Data
public class SignInPayload {
    private String username;
    private String password;
}
