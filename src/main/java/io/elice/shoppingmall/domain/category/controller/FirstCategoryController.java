package io.elice.shoppingmall.domain.category.controller;

import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryCreatePayload;
import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryUpdatePayload;
import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryDetailResult;
import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryResult;
import io.elice.shoppingmall.domain.category.service.FirstCategoryService;
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
@RequestMapping("/api/first_categories")
@RequiredArgsConstructor
@Tag(name = "(대카테고리)", description = "대카테고리")
public class FirstCategoryController {

    private final FirstCategoryService firstCategoryService;

    @PostMapping
    @Operation(summary = "대카테고리 생성", description = "대카테고리 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveFirstCategory(@RequestBody FirstCategoryCreatePayload payload) {
        Long saved = firstCategoryService.saveFirstCategory(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/list/{role}")
    @Operation(summary = "대카테고리 전체 조회", description = "대카테고리 전체 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<FirstCategoryResult>> findFirstCategories(@PathVariable(name = "role") String role) {
        List<FirstCategoryResult> allByCode = firstCategoryService.findFirstCategories(role);
        return new ResponseEntity<>(allByCode, HttpStatus.OK);
//        ResponseEntity<List<FirstCategoryResult>> response = new ResponseEntity<>(allByCode, HttpStatus.OK);
//        return response;
    }

    @GetMapping("/{id}")
    @Operation(summary = "대카테고리 단건 조회", description = "대카테고리 단건 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<FirstCategoryDetailResult> findById(@PathVariable(name = "id") Long firstCategoryId) {
        FirstCategoryDetailResult byId = firstCategoryService.findById(firstCategoryId);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "대카테고리 수정", description = "대카테고리 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateFirstCategory(@PathVariable(name = "id") Long id, @RequestBody FirstCategoryUpdatePayload payload) {
        Long updated = firstCategoryService.updateFirstCategory(id, payload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "대카테고리 삭제", description = "대카테고리 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteFirstCategory(@PathVariable(name = "id") Long id) {
        Long deleted = firstCategoryService.deleteFirstCategory(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
