package io.elice.shoppingmall.domain.item.service;

import io.elice.shoppingmall.domain.item.dto.payload.ItemCreatePayload;
import io.elice.shoppingmall.domain.item.dto.payload.ItemUpdatePayload;
import io.elice.shoppingmall.domain.item.dto.result.ItemDetailResult;
import io.elice.shoppingmall.domain.item.dto.result.ItemResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {

    // 생성
    Long saveItem(ItemCreatePayload payload);

    // Pagination 조회
    Page<ItemDetailResult> findPageItems(Long secondCategoryId, String name, Pageable pageable);

    // 유저가 세컨드 카테고리 통해서 조회
    List<ItemResult> findItems(Long secondCategoryId);

    ItemResult findItem(Long id);

    // 관리자가 조회
    List<ItemDetailResult> findAdminItems(Long secondCategoryId);

    ItemDetailResult findAdminItem(Long id);
    // 수정
    Long updateItem(Long id, ItemUpdatePayload payload);
    // 삭제
    Long deleteItem(Long id);
}
