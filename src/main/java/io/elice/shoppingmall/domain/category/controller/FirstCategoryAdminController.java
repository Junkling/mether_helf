package io.elice.shoppingmall.domain.category.controller;


import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryCreatePayload;
import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryUpdatePayload;
import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryResult;
import io.elice.shoppingmall.domain.category.service.FirstCategoryService;
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
@RequestMapping("/api/admin/first-categories")
@RequiredArgsConstructor
@Tag(name = "(관리자)", description = "관리자 대카테고리")
public class FirstCategoryAdminController {

    private final FirstCategoryService firstCategoryService;

    @PostMapping
    @Operation(summary = "대카테고리 생성", description = "대카테고리 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveFirstCategory(@RequestBody FirstCategoryCreatePayload payload) {
        Long saved = firstCategoryService.saveFirstCategory(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{firstCategoryId}")
    @Operation(summary = "대카테고리 수정", description = "대카테고리 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateFirstCategory(@PathVariable(name = "firstCategoryId") Long firstId, @RequestBody FirstCategoryUpdatePayload payload) {
        Long updated = firstCategoryService.updateFirstCategory(firstId, payload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{firstCategoryId}")
    @Operation(summary = "대카테고리 삭제", description = "대카테고리 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteFirstCategory(@PathVariable(name = "firstCategoryId") Long firstId) {
        Long deleted = firstCategoryService.deleteFirstCategory(firstId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "대카테고리 페이지조회", description = "대카테고리 페이지조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Page.class)))})
    public ResponseEntity<Page<FirstCategoryResult>> finAdminFirstCategories(@RequestParam(name = "role", required = false) String role
            , @RequestParam(name = "name", required = false) String name
            , @RequestParam(name = "size", defaultValue = "10") Integer size
            , @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Page<FirstCategoryResult> allFirstCategoryByPage = firstCategoryService.findAllFirstCategoryByPage(role, name, PageRequest.of(page, size));
        return new ResponseEntity<>(allFirstCategoryByPage, HttpStatus.OK);
    }

}
