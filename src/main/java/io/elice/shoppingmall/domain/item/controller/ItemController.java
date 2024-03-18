package io.elice.shoppingmall.domain.item.controller;

import io.elice.shoppingmall.domain.item.dto.result.ItemResult;
import io.elice.shoppingmall.domain.item.service.ItemService;
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
@RequestMapping("/api/items")
@Tag(name = "(상품)", description = "상품")
public class ItemController {
    private final ItemService itemService;

    // 유저가 세컨드 카테고리를 통해서 아이템 리스트을 조회시 사용
    @GetMapping("/list")
    @Operation(summary = "유저단 상품리스트 조회", description = "유저단 상품리스트 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "에러", content = @Content(schema = @Schema(implementation = List.class)))})
    public ResponseEntity<List<ItemResult>> findItems(@RequestParam(name = "secondCategoryId") Long secondCategoryId) {
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
}
