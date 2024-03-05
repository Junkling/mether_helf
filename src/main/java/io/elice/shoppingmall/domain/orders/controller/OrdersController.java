package io.elice.shoppingmall.domain.orders.controller;

import io.elice.shoppingmall.domain.orders.dto.payload.OrdersCreatePayload;
import io.elice.shoppingmall.domain.orders.service.OrdersService;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "(주문)", description = "주문")
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping("/admin-orders")
    @Operation(summary = "관리자 주문내역 조회", description = "관리자 주문내역 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public String viewAdminOrderPage(Long adminId){
        return "admin-orders/admin-orders";
    }

    @PostMapping("/new")
    @Operation(summary = "주문 생성", description = "주문 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public String saveOrder(@RequestBody OrdersCreatePayload payload, Model model){
        Long savedOrder = ordersService.saveOrder(payload);
        model.addAttribute("savedOrder", savedOrder);
        return "order-complete/order-complete";
    }

    @GetMapping
    @Operation(summary = "주문창 조회", description = "주문창 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public String viewOrderPage(Model model){
        return "order/order";
    }

    @DeleteMapping("/{orderId}")
    @Operation(summary = "주문 내역 삭제", description = "주문 내역 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteOrders(@PathVariable(name = "orderId") Long id){
        Long deletedOrder = ordersService.deleteOrder(id);
        return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
    }






}
