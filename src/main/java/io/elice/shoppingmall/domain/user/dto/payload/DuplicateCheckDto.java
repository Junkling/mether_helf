package io.elice.shoppingmall.domain.user.dto.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class DuplicateCheckDto {
    private String username;
    private String email;
    private String nickname;
}
