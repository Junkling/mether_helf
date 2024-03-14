package io.elice.shoppingmall.domain.category.controller;

import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import io.elice.shoppingmall.domain.category.service.SecondCategoryService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "(중카테고리)", description = "중카테고리")
@RequestMapping("/api/second-categories")
public class SecondCategoryController {

    private final SecondCategoryService secondCategoryService;

    @GetMapping("/list")
    @Operation(summary = "중카테고리 전체 조회", description = "중카테고리 전체 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<SecondCategoryResult>> findSecondCategories(@RequestParam(name = "firstCategoryId", required = false) Long id) {
        List<SecondCategoryResult> secondCategories = secondCategoryService.findSecondCategories(id);
        return new ResponseEntity<>(secondCategories, HttpStatus.OK);
    }

    @GetMapping("")
    @Operation(summary = "중카테고리 페이지", description = "중카테고리 페이지")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Page.class)))})
    public ResponseEntity<Page<SecondCategoryResult>> findPageSecondCategories(
            @RequestParam(name = "firstCategoryName", required = false) Long firstCategoryId
            , @RequestParam(name = "name", required = false) String name
            , @RequestParam(name = "page", defaultValue = "0") Integer page
            , @RequestParam(name = "size", defaultValue = "10") Integer size) {
        Page<SecondCategoryResult> secondCategories = secondCategoryService.findAllSecondCategoryByPage(firstCategoryId, name, PageRequest.of(page,size));
        return new ResponseEntity<>(secondCategories, HttpStatus.OK);
    }

}
