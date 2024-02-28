package io.elice.shoppingmall.domain.category.service;

import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryCreatePayload;
import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryUpdatePayload;
import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryDetailResult;
import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryResult;
import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import io.elice.shoppingmall.domain.category.repository.FirstCategoryRepository;
import io.elice.shoppingmall.util.mapsturct.category.FirstCategoryDetailResultMapper;
import io.elice.shoppingmall.util.mapsturct.category.FirstCategoryResultMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstCategoryServiceImpl implements FirstCategoryService {

    private final FirstCategoryRepository firstCategoryRepository;

    private final FirstCategoryResultMapper firstCategoryResultMapper;

    private final FirstCategoryDetailResultMapper firstCategoryDetailResultMapper;

    /**
     * 대카테고리 생성
     * @param payload: name= 카테고리 이름, role= 사용자 권한
     * @return: 저장된 entity에 id
     */
    @Transactional
    @Override
    public Long saveFirstCategory(FirstCategoryCreatePayload payload) {
        FirstCategory firstCategory = firstCategoryRepository.save(
                FirstCategory.builder()
                        .name(payload.getName())
                        .role(payload.getRole())
                        .build());
//        FirstCategoryResult dto = firstCategoryResultMapper.toDto(firstCategory);
        return firstCategory.getId();
    }

    @Override
    public List<FirstCategoryResult> findFirstCategories(String role) {
        List<FirstCategory> all = firstCategoryRepository.findAllByRole(role);
        List<FirstCategoryResult> dtoList = firstCategoryResultMapper.toDtoList(all);
        return dtoList;
    }

    @Override
    public FirstCategoryDetailResult findById(Long firstCategoryId) {
        FirstCategory firstCategory = firstCategoryRepository.findById(firstCategoryId).orElseThrow();
        FirstCategoryDetailResult dto = firstCategoryDetailResultMapper.toDto(firstCategory);
        return dto;
    }

    @Transactional
    @Override
    public Long updateFirstCategory(Long id, FirstCategoryUpdatePayload payload) {
        FirstCategory firstCategory = firstCategoryRepository.findById(id).orElseThrow();
        firstCategory.updateFirstCategory(payload);
        return firstCategory.getId();
    }

    @Transactional
    @Override
    public Long deleteFirstCategory(Long id) {
//        FirstCategory firstCategory = firstCategoryRepository.findById(id).orElseThrow();
//        firstCategoryRepository.delete(firstCategory);
        firstCategoryRepository.deleteById(id);
        return id;
    }
}
