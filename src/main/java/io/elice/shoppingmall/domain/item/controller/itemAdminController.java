package io.elice.shoppingmall.domain.item.controller;

import io.elice.shoppingmall.domain.item.dto.payload.ItemCreatePayload;
import io.elice.shoppingmall.domain.item.dto.payload.ItemUpdatePayload;
import io.elice.shoppingmall.domain.item.dto.result.ItemDetailResult;
import io.elice.shoppingmall.domain.item.service.ItemService;
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
@RequestMapping("/api/admin/items")
@Tag(name = "(관리자)", description = "관리자 상품")
public class itemAdminController {
    private final ItemService itemService;

    // 생성
    @PostMapping
    @Operation(summary = "상품 생성", description = "상품 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveItem(@RequestBody ItemCreatePayload payload) {
        Long saved = itemService.saveItem(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    // 수정
    @PutMapping("/{itemId}")
    @Operation(summary = "상품 수정", description = "상품 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateItem(@PathVariable(name = "itemId") Long itemId, @RequestBody ItemUpdatePayload payload) {
        Long updated = itemService.updateItem(itemId, payload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    // 삭제
    @DeleteMapping("/{itemId}")
    @Operation(summary = "상품 삭제", description = "상품 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteItem(@PathVariable(name = "itemId") Long itemId) {
        Long deleted = itemService.deleteItem(itemId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    // Pagination
    // 조회
    @GetMapping("")
    @Operation(summary = "상품 페이지 조회", description = "상품 페이지 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<Page<ItemDetailResult>> findAdminItems(@RequestParam(name = "secondCategoryId", required = false) Long secondCategoryId
            , @RequestParam(name = "name", required = false) String name
            , @RequestParam(name = "size", defaultValue = "10") Integer size
            , @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Page<ItemDetailResult> pageItems = itemService.findPageItems(secondCategoryId, name, PageRequest.of(page, size));
        return new ResponseEntity<>(pageItems, HttpStatus.OK);
    }
    // 관리자가 아이템 상세조회시 사용
    @GetMapping("/{itemId}")
    @Operation(summary = "상품 상세 조회", description = "상품 상세 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ItemDetailResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = ItemDetailResult.class)))})
    public ResponseEntity<ItemDetailResult> findAdminItem(@PathVariable(name = "itemId") Long itemId) {
        ItemDetailResult adminItem = itemService.findAdminItem(itemId);
        return new ResponseEntity<>(adminItem, HttpStatus.OK);
    }


}
