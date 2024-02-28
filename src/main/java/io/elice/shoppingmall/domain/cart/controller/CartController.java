package io.elice.shoppingmall.domain.cart.controller;

import io.elice.shoppingmall.domain.cart.dto.payload.CartCreatePayload;
import io.elice.shoppingmall.domain.cart.dto.payload.CartUpdatePayload;
import io.elice.shoppingmall.domain.cart.dto.result.CartResult;
import io.elice.shoppingmall.domain.cart.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carts")
@Tag(name = "(장바구니)", description = "장바구니")
public class CartController {
    private final CartService cartService;

    @PostMapping
    @Operation(summary = "장바구니 생성", description = "장바구니 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveCart(@RequestBody CartCreatePayload payload) {
        Long saved = cartService.saveCart(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "장바구니 전체조회", description = "장바구니 전체조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<CartResult>> findCarts(@PathVariable(name = "id") Long userId) {
        List<CartResult> carts = cartService.findCarts(userId);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "장바구니 단건조회", description = "장바구니 단건조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<CartResult> findCart(@PathVariable(name = "id") Long id) {
        CartResult cart = cartService.findCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "장바구니 수정", description = "장바구니 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateCart(@PathVariable(name = "id") Long id, @RequestBody CartUpdatePayload payload) {
        Long updated = cartService.updateCart(id, payload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "장바구니 삭제", description = "장바구니 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteCart(@PathVariable(name = "id") Long id) {
        Long deleted = cartService.deleteCart(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
