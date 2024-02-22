package io.elice.shoppingmall.security;

import io.elice.shoppingmall.code.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyTokenPayload {
    private Long userId;
    private String username;
    private List<String> roles = new ArrayList<>();
}
