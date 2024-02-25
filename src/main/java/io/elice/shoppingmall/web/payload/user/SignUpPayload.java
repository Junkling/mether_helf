package io.elice.shoppingmall.web.payload.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class SignUpPayload {
    @Schema(description = "로그인 id")
    private String username;
    @Schema(description = "닉네임")
    private String nickname;
    @Schema(description = "비밀번호")
    private String password;

    @Email
    @Schema(description = "이메일")
    private String email;

    @Schema(description = "직종")
    private String job;

    @Schema(description = "소속")
    private String company;

    @Schema(description = "권한")
    private String role;

}
