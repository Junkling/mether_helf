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
import org.springframework.stereotype.Service;

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
        FirstCategory firstCategory = firstCategoryRepository.findById(payload.getFirstCategoryId()).orElseThrow();
        SecondCategory secondCategory = secondCategoryRepository.save(
                SecondCategory.builder()
                        .name(payload.getName())
                        .firstCategory(firstCategory)
                        .build());
        return secondCategory.getId();
    }

    @Override
    public List<SecondCategoryResult> findSecondCategories(Long id) {
        List<SecondCategory> all = secondCategoryRepository.findByFirstCategoryId(id);
        List<SecondCategoryResult> dtoList = secondCategoryResultMapper.toDtoList(all);
        return dtoList;
    }

    @Transactional
    @Override
    public Long updateSecondCategory(Long id, SecondCategoryUpdatePayload payload) {
        FirstCategory firstCategory = firstCategoryRepository.findById(payload.getFirstCategoryId()).orElseThrow();
        SecondCategory secondCategory = secondCategoryRepository.findById(id).orElseThrow();
        secondCategory.updateSecondCategory(payload.getName(), firstCategory);
        return secondCategory.getId();
    }

    @Override
    public Long deleteSecondCategory(Long id) {
        secondCategoryRepository.deleteById(id);
        return id;
    }
}
