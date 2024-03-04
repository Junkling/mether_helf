package io.elice.shoppingmall.domain.delivery.controller;

import io.elice.shoppingmall.domain.delivery.dto.payload.*;
import io.elice.shoppingmall.domain.delivery.dto.result.DeliveryResult;
import io.elice.shoppingmall.domain.delivery.service.DeliveryService;
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
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery")
@Tag(name = "(배달)", description = "배달")

public class DeliveryController {
    private final DeliveryService deliveryService;
    @PostMapping
    @Operation(summary = "배달 생성", description = "배달 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveDelivery(@RequestBody DeliveryCreatePayload payload){
        Long saved = deliveryService.saveDelivery(payload);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "배달 조회", description = "배달 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<DeliveryResult> findDelivery(@PathVariable(name = "id") Long id){
        DeliveryResult delivery = deliveryService.findDelivery(id);
        return new ResponseEntity<>(delivery,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "배달 삭제", description = "배달 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteDelivery(@PathVariable(name = "id") Long id){
        Long deleted = deliveryService.deleteDelivery(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
