package io.elice.shoppingmall.domain.bill.controller;

import io.elice.shoppingmall.domain.bill.dto.payload.BillCreatePayload;
import io.elice.shoppingmall.domain.bill.dto.payload.BillUpdatePayload;
import io.elice.shoppingmall.domain.bill.dto.result.BillResult;
import io.elice.shoppingmall.domain.bill.service.BillService;
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
@RequestMapping("/api/bills")
@Tag(name = "(영수증)", description = "영수증")
public class BillController {
    private final BillService billService;

    @PostMapping
    @Operation(summary = "영수증 생성", description = "영수증 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveBill(@RequestBody BillCreatePayload payload){
        Long saved = billService.saveBill(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // 영수증 전체 조회 만들기

    @PutMapping("/{id}")
    @Operation(summary = "영수증 단건 조회", description = "영수증 단건 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<BillResult> findBill(@PathVariable(name = "id") Long id){
        BillResult bill = billService.findBill(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "영수증 삭제", description = "영수증 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteCart(@PathVariable(name = "id") Long id){
        Long deleted = billService.deleteBill(id);
        return new ResponseEntity<>(deleted,HttpStatus.OK);
    }

}
