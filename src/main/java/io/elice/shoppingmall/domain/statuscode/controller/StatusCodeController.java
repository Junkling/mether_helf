package io.elice.shoppingmall.domain.statuscode.controller;

import io.elice.shoppingmall.domain.bill.dto.payload.BillCreatePayload;
import io.elice.shoppingmall.domain.bill.dto.result.BillResult;
import io.elice.shoppingmall.domain.statuscode.dto.payload.*;
import io.elice.shoppingmall.domain.statuscode.dto.result.StatusCodeResult;
import io.elice.shoppingmall.domain.statuscode.service.StatusCodeService;

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
@RequestMapping("/api/statuscode")
@Tag(name = "(코드)", description = "코드")
public class StatusCodeController {
    private final StatusCodeService statusCodeService;

    @PostMapping
    @Operation(summary = "코드 생성", description = "코드 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveStatusCode(@RequestBody StatusCodeCreatePayload payload){
        Long saved = statusCodeService.saveStatusCode(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "특정 코드 조회", description = "특정 코드 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = StatusCodeResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = StatusCodeResult.class)))})
    public ResponseEntity<StatusCodeResult> findStatusCode(@PathVariable(name = "id") Long id){
        StatusCodeResult statusCode = statusCodeService.findStatusCode(id);
        return new ResponseEntity<>(statusCode, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "특정 코드 삭제", description = "특정 코드 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteStatusCode(@PathVariable(name = "id") Long id){
        Long deleted = statusCodeService.deleteStatusCode(id);
        return new ResponseEntity<>(deleted,HttpStatus.OK);
    }
}
