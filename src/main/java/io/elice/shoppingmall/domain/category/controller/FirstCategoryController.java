package io.elice.shoppingmall.domain.category.controller;

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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/first-categories")
@RequiredArgsConstructor
@Tag(name = "(대카테고리)", description = "대카테고리")
public class FirstCategoryController {

    private final FirstCategoryService firstCategoryService;

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('GREEN') or hasAuthority(#role)")
    @Operation(summary = "대카테고리 전체 조회", description = "대카테고리 전체 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<FirstCategoryResult>> findFirstCategories(@RequestParam(name = "role", required = false) String role) {
        List<FirstCategoryResult> allByCode = firstCategoryService.findFirstCategories(role);
        return new ResponseEntity<>(allByCode, HttpStatus.OK);
//        ResponseEntity<List<FirstCategoryResult>> response = new ResponseEntity<>(allByCode, HttpStatus.OK);
//        return response;
    }

    @GetMapping("/{firstCategoryId}")
    @Operation(summary = "대카테고리 단건 조회", description = "대카테고리 단건 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = FirstCategoryDetailResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = FirstCategoryDetailResult.class)))})
    public ResponseEntity<FirstCategoryResult> findById(@PathVariable(name = "firstCategoryId") Long firstCategoryId) {
        FirstCategoryResult byId = firstCategoryService.findById(firstCategoryId);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }
}
