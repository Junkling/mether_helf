package io.elice.shoppingmall.domain.item.service;

import io.elice.shoppingmall.domain.category.entity.SecondCategory;
import io.elice.shoppingmall.domain.category.repository.SecondCategoryRepository;
import io.elice.shoppingmall.domain.item.dto.payload.ItemCreatePayload;
import io.elice.shoppingmall.domain.item.dto.payload.ItemUpdatePayload;
import io.elice.shoppingmall.domain.item.dto.result.ItemDetailResult;
import io.elice.shoppingmall.domain.item.dto.result.ItemResult;
import io.elice.shoppingmall.domain.item.entity.Item;
import io.elice.shoppingmall.domain.item.repository.ItemRepository;
import io.elice.shoppingmall.util.mapsturct.item.ItemDetailResultMapper;
import io.elice.shoppingmall.util.mapsturct.item.ItemResultMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final SecondCategoryRepository secondCategoryRepository;
    private final ItemResultMapper itemResultMapper;
    private final ItemDetailResultMapper itemDetailResultMapper;

    @Transactional
    @Override
    public Long saveItem(ItemCreatePayload payload) {
        SecondCategory secondCategory = secondCategoryRepository.findById(payload.getSecondCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("해당 중카테고리가 없습니다. secondCategoryId=" + payload.getSecondCategoryId()));
        Item save = itemRepository.save(
                Item.builder()
                        .name(payload.getName())
                        .content(payload.getContent())
                        .price(payload.getPrice())
                        .stock(payload.getStock())
                        .discountPer(payload.getDiscountPer())
                        .secondCategory(secondCategory)
                        .build());
        return save.getId();
    }

    // Pagination 조회
    @Override
    public Page<ItemDetailResult> findPageItems(Long secondCategoryId, String name, Pageable pageable) {
        if (secondCategoryId != null && secondCategoryId !=0) {
            return itemRepository.findAllBySecondCategoryId(secondCategoryId, pageable).map(itemDetailResultMapper::toDto);
        } else if (StringUtils.hasText(name)) {
            return itemRepository.findAllByNameContaining(name, pageable).map(itemDetailResultMapper::toDto);
        }
        return itemRepository.findAll(pageable).map(itemDetailResultMapper::toDto);
    }

    // 유저가 세컨드 카테고리를 통해서 아이템리스트을 조회시 사용
    @Override
    public List<ItemResult> findItems(Long secondCategoryId) {
        List<Item> itemList = itemRepository.findAllBySecondCategoryId(secondCategoryId);
        List<ItemResult> dtoList = itemResultMapper.toDtoList(itemList);
        return dtoList;
    }
    // 유저가 아이템을 단건 조회시 사용
    @Override
    public ItemResult findItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id" + id));
        ItemResult dto = itemResultMapper.toDto(item);
        return dto;
    }
    // 관리자가 아이템리스트를 조회시 사용
    @Override
    public List<ItemDetailResult> findAdminItems(Long secondCategoryId) {
        List<Item> itemList = itemRepository.findAllBySecondCategoryId(secondCategoryId);
        List<ItemDetailResult> dtoList = itemDetailResultMapper.toDtoList(itemList);
        return dtoList;
    }
    // 관리자가 아이템을 단건 조회시 사용
    @Override
    public ItemDetailResult findAdminItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id" + id));
        ItemDetailResult dto = itemDetailResultMapper.toDto(item);
        return dto;
    }


    @Transactional
    @Override
    public Long updateItem(Long id, ItemUpdatePayload payload) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id" + id));
        SecondCategory secondCategory = secondCategoryRepository.findById(payload.getSecondCategoryId()).orElseThrow();
        item.updateItem(payload.getName(), payload.getContent() ,payload.getPrice(), payload.getStock(), payload.getDiscountPer(), secondCategory);
        return item.getId();
    }

    @Transactional
    @Override
    public Long deleteItem(Long id) {
        itemRepository.deleteById(id);
        return id;
    }
}
