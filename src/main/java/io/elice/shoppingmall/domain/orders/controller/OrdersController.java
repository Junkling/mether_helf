package io.elice.shoppingmall.domain.orders.controller;

import io.elice.shoppingmall.domain.orders.dto.payload.OrdersCreatePayload;
import io.elice.shoppingmall.domain.orders.dto.payload.OrdersUpdatePayload;
import io.elice.shoppingmall.domain.orders.dto.result.OrdersResult;
import io.elice.shoppingmall.domain.orders.service.OrdersService;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "(주문)", description = "주문")
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping()
    @Operation(summary = "주문내역 전체조회", description = "주문내역 전체조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Page.class)))})
    public ResponseEntity<Page<OrdersResult>> findAllOrders(@AuthenticationPrincipal Long userId,
            @RequestParam(name = "size", defaultValue = "5") Integer size,
            @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Page<OrdersResult> orders = ordersService.findOrders(userId, PageRequest.of(page, size));
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    @Operation(summary = "주문 단일 조회", description = "주문 단일 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = OrdersResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = OrdersResult.class)))})
    public ResponseEntity<OrdersResult> findOrder(@PathVariable(name = "orderId") Long orderId) {
        OrdersResult ordersResult = ordersService.findOrder(orderId);
        return new ResponseEntity<>(ordersResult, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "주문 생성", description = "주문 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveOrder(@RequestBody @Validated OrdersCreatePayload ordersCreatePayload, @AuthenticationPrincipal Long userId) {
        ordersCreatePayload.setUserId(userId);
        Long saved = ordersService.saveOrder(ordersCreatePayload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    @Operation(summary = "주문 상태 수정", description = "주문 상태 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateOrder(@PathVariable(name = "orderId") Long orderId, @RequestBody OrdersUpdatePayload ordersUpdatePayload) {
        Long updated = ordersService.updateOrder(orderId, ordersUpdatePayload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    @Operation(summary = "주문 삭제", description = "주문 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteOrder(@PathVariable(name = "orderId") Long orderId) {
        Long deleted = ordersService.deleteOrder(orderId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }


}
