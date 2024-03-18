package io.elice.shoppingmall.domain.user.controller;

import io.elice.shoppingmall.domain.user.dto.payload.UserRoleEditPayload;
import io.elice.shoppingmall.domain.user.dto.payload.UserUpdatePayload;
import io.elice.shoppingmall.domain.user.dto.result.UserResult;
import io.elice.shoppingmall.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
@Tag(name = "(관리자 -> 계정)", description = "계정 관련")
public class UserAdminController {
    private final UserService userService;

    @GetMapping()
    @Operation(summary = "유저 전체 조회", description = "유저 전체 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Page.class)))})
    public ResponseEntity<Page<UserResult>> findAllUser(@RequestParam(name = "role", required = false) String role
            , @RequestParam(name = "nickname", required = false) String nickname
            , @RequestParam(name = "size", defaultValue = "10") Integer size
            , @RequestParam(name = "page", defaultValue = "0") Integer page) {

        return new ResponseEntity<>(userService.findAllUserByPage(nickname, role, PageRequest.of(page, size)), HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    @Operation(summary = "유저 권한 변경", description = "유저 권한 변경")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> changeUserRole(@RequestBody UserRoleEditPayload payload, @PathVariable(name = "userId") Long userId) {
        Long result = userService.updateUserRole(userId, payload);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    @Operation(summary = "유저 단일 조회", description = "유저 단일 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = UserResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = UserResult.class)))})
    public ResponseEntity<UserResult> findOneByUserId(@PathVariable(name = "userId") Long userId) {
        return new ResponseEntity<>(userService.findOneById(userId), HttpStatus.OK);
    }

}
