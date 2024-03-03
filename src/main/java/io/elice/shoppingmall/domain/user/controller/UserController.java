package io.elice.shoppingmall.domain.user.controller;

import io.elice.shoppingmall.domain.user.dto.payload.DuplicateCheckDto;
import io.elice.shoppingmall.domain.user.service.UserService;
import io.elice.shoppingmall.domain.user.dto.payload.SignInPayload;
import io.elice.shoppingmall.domain.user.dto.payload.SignUpPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "(계정)", description = "계정 관련")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "회원가입")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> signUp(@RequestBody SignUpPayload payload) {
        Long saved = userService.save(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/duplicate")
    @Operation(summary = "id 중복 확인", description = "id 중복 확인")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Boolean.class)))})
    public ResponseEntity<Boolean> duplicateCheck(@RequestParam(name = "username",required = false) String username
            ,@RequestParam(name = "email",required = false) String email
            ,@RequestParam(name = "nickname",required = false) String nickname) {
        userService.checkDuplicate(new DuplicateCheckDto(username, email, nickname));
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    @Operation(summary="로그인", description="로그인")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = String.class ))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = String.class)))})
    public ResponseEntity<String> signIn(@RequestBody SignInPayload payload) throws BadRequestException {
        String token = userService.signIn(payload);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
