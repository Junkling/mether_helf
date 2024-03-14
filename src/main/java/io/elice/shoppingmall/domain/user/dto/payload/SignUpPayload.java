package io.elice.shoppingmall.domain.user.dto.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SignUpPayload {

    @NotEmpty
    @Schema(description = "로그인 id")
    private String username;
    @NotEmpty
    @Schema(description = "닉네임")
    private String nickname;

    @NotEmpty
    @Schema(description = "비밀번호")
    private String password;

    @Email
    @Schema(description = "이메일")
    private String email;


    @NotEmpty
    @Schema(description = "직종")
    private String job;

    @NotEmpty
    @Schema(description = "소속")
    private String company;

    @Schema(description = "권한")
    private Long roleId;

}
