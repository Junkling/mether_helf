package io.elice.shoppingmall.domain.category.controller;

import io.elice.shoppingmall.domain.category.dto.payload.SecondCategoryCreatePayload;
import io.elice.shoppingmall.domain.category.dto.payload.SecondCategoryUpdatePayload;
import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import io.elice.shoppingmall.domain.category.service.SecondCategoryService;
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
@Tag(name = "(중카테고리)", description = "중카테고리")
@RequestMapping("/api/second_categories")
public class SecondCategoryController {

    private final SecondCategoryService secondCategoryService;

    @PostMapping
    @Operation(summary = "중카테고리 생성", description = "중카테고리 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveSecondCategory(@RequestBody SecondCategoryCreatePayload payload) {
        Long saved = secondCategoryService.saveSecondCategory(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/list/{first_category_id}")
    @Operation(summary = "중카테고리 전체 조회", description = "중카테고리 전체 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<SecondCategoryResult>> findSecondCategories(@PathVariable(name = "first_category_id") Long id) {
        List<SecondCategoryResult> secondCategories = secondCategoryService.findSecondCategories(id);
        return new ResponseEntity<>(secondCategories, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    @Operation(summary = "중카테고리 수정", description = "중카테고리 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateSecondCategory(@PathVariable(name = "id") Long id, SecondCategoryUpdatePayload payload) {
        Long updated = secondCategoryService.updateSecondCategory(id, payload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "중카테고리 삭제", description = "중카테고리 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
   public ResponseEntity<Long> deleteSecondCategories(@PathVariable(name = "id") Long id) {
        Long deleted = secondCategoryService.deleteSecondCategory(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
