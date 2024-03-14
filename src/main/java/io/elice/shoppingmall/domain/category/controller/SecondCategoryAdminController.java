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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "(관리자)", description = "관리자 중카테고리")
@RequestMapping("/api/admin/second-categories")
public class SecondCategoryAdminController {

    private final SecondCategoryService secondCategoryService;
    @PostMapping
    @Operation(summary = "중카테고리 생성", description = "중카테고리 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveSecondCategory(@RequestBody SecondCategoryCreatePayload payload) {
        Long saved = secondCategoryService.saveSecondCategory(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @PutMapping("/{secondCategoryId}")
    @Operation(summary = "중카테고리 수정", description = "중카테고리 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateSecondCategory(@PathVariable(name = "secondCategoryId") Long id, @RequestBody SecondCategoryUpdatePayload payload) {
        Long updated = secondCategoryService.updateSecondCategory(id, payload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{secondCategoryId}")
    @Operation(summary = "중카테고리 삭제", description = "중카테고리 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteSecondCategories(@PathVariable(name = "secondCategoryId") Long secondCategoryId) {
        Long deleted = secondCategoryService.deleteSecondCategory(secondCategoryId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

//     관리자가 카테고리 리스트를 조회시 사용(관리)
    @GetMapping
    @Operation(summary = "중카테고리 페이지 조회", description = "중카테고리 페이지 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Page.class)))})
    public ResponseEntity<Page<SecondCategoryResult>> findAdminSecondCategories(@RequestParam(name = "firstCategoryId", required = false) Long firstCategoryId
            , @RequestParam(name = "name",required = false) String name
            , @RequestParam(name = "size", defaultValue = "10") Integer size
            , @RequestParam(name = "page", defaultValue = "0") Integer page){
        Page<SecondCategoryResult> secondCategoryResultPage = secondCategoryService.findAllSecondCategoryByPage(firstCategoryId, name, PageRequest.of(page, size));
        return new ResponseEntity<>(secondCategoryResultPage, HttpStatus.OK);
    }

    //    단건 조회
    @GetMapping("/{secondCategoryId}")
    @Operation(summary = "중카테고리 단건 조회", description = "중카테고리 단건 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = SecondCategoryResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = SecondCategoryResult.class)))})
    public ResponseEntity<SecondCategoryResult> findAdminCategory(@PathVariable(name = "secondCategoryId") Long secondCategoryId) {
        SecondCategoryResult secondCategory = secondCategoryService.findSecondCategory(secondCategoryId);
        return new ResponseEntity<>(secondCategory, HttpStatus.OK);
    }


}
