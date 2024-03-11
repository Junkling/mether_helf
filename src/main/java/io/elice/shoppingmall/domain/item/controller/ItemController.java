package io.elice.shoppingmall.domain.item.controller;

import io.elice.shoppingmall.domain.item.dto.payload.ItemCreatePayload;
import io.elice.shoppingmall.domain.item.dto.payload.ItemUpdatePayload;
import io.elice.shoppingmall.domain.item.dto.result.ItemDetailResult;
import io.elice.shoppingmall.domain.item.dto.result.ItemResult;
import io.elice.shoppingmall.domain.item.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
@Tag(name = "(상품)", description = "상품")
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    @Operation(summary = "상품 생성", description = "상품 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> saveItem(@RequestBody ItemCreatePayload payload) {
        Long saved = itemService.saveItem(payload);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Pagination
    @GetMapping("/List/{secondCategoryId}")
    @Operation(summary = "상품리스트(페이지) 조회", description = "상품리스트(페이지) 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Page.class)))})
    public ResponseEntity<Page<ItemResult>> findPageItems(@PathVariable(name = "secondCategoryId") Long secondCategoryId, Pageable pageable) {
        Page<ItemResult> pageItems = itemService.findPageItems(secondCategoryId, pageable);
        return new ResponseEntity<>(pageItems, HttpStatus.OK);
    }


    // 유저가 세컨드 카테고리를 통해서 아이템 리스트을 조회시 사용
    @GetMapping("/list/{secondCategoryId}")
    @Operation(summary = "유저단 상품리스트 조회", description = "유저단 상품리스트 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<ItemResult>> findItems(@PathVariable(name = "secondCategoryId") Long secondCategoryId) {
        List<ItemResult> items = itemService.findItems(secondCategoryId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // 유저가 아이템 상세조회시 사용
    @GetMapping("/{itemId}")
    @Operation(summary = "유저단 상품 상세 조회", description = "유저단 상품 상세 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ItemResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = ItemResult.class)))})
    public ResponseEntity<ItemResult> findItem(@PathVariable(name = "itemId") Long itemId) {
        ItemResult item = itemService.findItem(itemId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    // 관리자가 아이템 리스트를 조회시 사용
    @GetMapping("/admin/list/{secondCategoryId}")
    @Operation(summary = "관리자단 상품 리스트 조회", description = "관리자단 상품 리스트 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<ItemDetailResult>> findAdminItems(@PathVariable(name = "secondCategoryId") Long secondCategoryId) {
        List<ItemDetailResult> adminItems = itemService.findAdminItems(secondCategoryId);
        return new ResponseEntity<>(adminItems, HttpStatus.OK);
    }

    // 관리자가 아이템 상세조회시 사용
    @GetMapping("/admin/{itemId}")
    @Operation(summary = "관리자단 상품 상세 조회", description = "관리자단 상품 상세 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ItemDetailResult.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = ItemDetailResult.class)))})
    public ResponseEntity<ItemDetailResult> findAdminItem(@PathVariable(name = "itemId") Long itemId) {
        ItemDetailResult adminItem = itemService.findAdminItem(itemId);
        return new ResponseEntity<>(adminItem, HttpStatus.OK);
    }

    @PutMapping("/{itemId}")
    @Operation(summary = "상품 수정", description = "상품 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> updateItem(@PathVariable(name = "itemId") Long itemId, @RequestBody ItemUpdatePayload payload) {
        Long updated = itemService.updateItem(itemId, payload);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    @Operation(summary = "상품 삭제", description = "상품 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = Long.class)))})
    public ResponseEntity<Long> deleteItem(@PathVariable(name = "itemId") Long itemId) {
        Long deleted = itemService.deleteItem(itemId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
