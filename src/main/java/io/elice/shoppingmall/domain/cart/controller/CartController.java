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
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveCart(@RequestBody CartCreatePayload payload) {
        Long saved = cartService.saveCart(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/list/{userId}")
    @Operation(summary = "장바구니 전체조회", description = "장바구니 전체조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<CartResult>> findCarts(@PathVariable(name = "userId") Long userId) {
        List<CartResult> carts = cartService.findCarts(userId);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    @Operation(summary = "장바구니 단건조회", description = "장바구니 단건조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = CartResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = CartResult.class)))})
    public ResponseEntity<CartResult> findCart(@PathVariable(name = "cartId") Long id) {
        CartResult cart = cartService.findCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/{cartId}")
    @Operation(summary = "장바구니 수정", description = "장바구니 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateCart(@PathVariable(name = "cartId") Long id, @RequestBody CartUpdatePayload payload) {
        Long updated = cartService.updateCart(id, payload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{cartId}")
    @Operation(summary = "장바구니 삭제", description = "장바구니 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteCart(@PathVariable(name = "cartId") Long id) {
        Long deleted = cartService.deleteCart(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @DeleteMapping("/list/{userId}")
    @Operation(summary = "장바구니 전체삭제", description = "장바구니 전체삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteAllCart(@PathVariable(name = "userId") Long userId) {
        cartService.deleteAllCart(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
