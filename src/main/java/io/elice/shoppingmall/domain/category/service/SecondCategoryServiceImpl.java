package io.elice.shoppingmall.domain.category.service;

import io.elice.shoppingmall.domain.category.dto.payload.SecondCategoryCreatePayload;
import io.elice.shoppingmall.domain.category.dto.payload.SecondCategoryUpdatePayload;
import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import io.elice.shoppingmall.domain.category.entity.SecondCategory;
import io.elice.shoppingmall.domain.category.repository.SecondCategoryRepository;
import io.elice.shoppingmall.util.mapsturct.category.SecondCategoryResultMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import io.elice.shoppingmall.domain.category.repository.FirstCategoryRepository;

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
    public Page<SecondCategoryResult> findAllPage(String firstCategoryName, String name, Pageable pageable) {
        if (StringUtils.hasText(firstCategoryName)) {
            FirstCategory firstCategory = firstCategoryRepository.findByName(firstCategoryName).orElseThrow();
            secondCategoryRepository.findByFirstCategoryId(firstCategory.getId() , pageable).map(secondCategoryResultMapper::toDto);
        } else if (StringUtils.hasText(name)) {
            secondCategoryRepository.findByNameContaining(name, pageable).map(secondCategoryResultMapper::toDto);
        }
        return secondCategoryRepository.findAll(pageable).map(secondCategoryResultMapper::toDto);
    }
}
