package io.elice.shoppingmall.domain.category.service;

import io.elice.shoppingmall.domain.category.dto.payload.SecondCategoryCreatePayload;
import io.elice.shoppingmall.domain.category.dto.payload.SecondCategoryUpdatePayload;
import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import io.elice.shoppingmall.domain.category.entity.SecondCategory;
import io.elice.shoppingmall.domain.category.repository.FirstCategoryRepository;
import io.elice.shoppingmall.domain.category.repository.SecondCategoryRepository;
import io.elice.shoppingmall.util.mapsturct.category.SecondCategoryResultMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecondCategoryServiceImpl implements SecondCategoryService {

    private final SecondCategoryRepository secondCategoryRepository;

    private final FirstCategoryRepository firstCategoryRepository;

    private final SecondCategoryResultMapper secondCategoryResultMapper;

    @Transactional
    @Override
    public Long saveSecondCategory(SecondCategoryCreatePayload payload) {
        FirstCategory firstCategory = firstCategoryRepository.findById(payload.getFirstCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("해당 대카테고리가 없습니다. firstCategoryId=" + payload.getFirstCategoryId()));
        SecondCategory secondCategory = secondCategoryRepository.save(
                SecondCategory.builder()
                        .name(payload.getName())
                        .firstCategory(firstCategory)
                        .build());
        return secondCategory.getId();
    }

    @Override
    public List<SecondCategoryResult> findSecondCategories(Long firstCategoryId) {
        if (firstCategoryId == null) {
            return secondCategoryResultMapper.toDtoList(secondCategoryRepository.findAll());
        }
        List<SecondCategory> all = secondCategoryRepository.findByFirstCategoryId(firstCategoryId);
        List<SecondCategoryResult> dtoList = secondCategoryResultMapper.toDtoList(all);

        return dtoList;
    }

    @Transactional
    @Override
    public Long updateSecondCategory(Long id, SecondCategoryUpdatePayload payload) {
        FirstCategory firstCategory = firstCategoryRepository.findById(payload.getFirstCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("해당 대카테고리가 없습니다. firstCategoryId=" + payload.getFirstCategoryId()));
        SecondCategory secondCategory = secondCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 중카테고리가 없습니다. id=" + id));
        secondCategory.updateSecondCategory(payload.getName(), firstCategory);
        return secondCategory.getId();
    }

    @Transactional
    @Override
    public Long deleteSecondCategory(Long id) {
        secondCategoryRepository.deleteById(id);
        return id;
    }

    @Override
    public Page<SecondCategoryResult> findAllSecondCategoryByPage(Long firstCategoryId, String name, Pageable pageable) {
        if (firstCategoryId != null && firstCategoryId != 0) {
            return secondCategoryRepository.findByFirstCategoryId(firstCategoryId, pageable).map(secondCategory -> secondCategoryResultMapper.toDto(secondCategory));
        } else if (StringUtils.hasText(name)) {
            Page<SecondCategory> byNameContaining = secondCategoryRepository.findByNameContaining(name, pageable);
            return byNameContaining.map(secondCategory -> secondCategoryResultMapper.toDto(secondCategory));
        }
        return secondCategoryRepository.findAll(pageable).map(secondCategory -> secondCategoryResultMapper.toDto(secondCategory));
    }

    @Override
    public SecondCategoryResult findSecondCategory(Long id) {
        SecondCategory secondCategory = secondCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 중카테고리가 없습니다. secondCategoryId=" + id));
        SecondCategoryResult dto = secondCategoryResultMapper.toDto(secondCategory);
        return dto;
    }
}
