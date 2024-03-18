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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        if (!StringUtils.hasText(role)) {
            return firstCategoryResultMapper.toDtoList(firstCategoryRepository.findAll());
        }
        List<FirstCategory> all = firstCategoryRepository.findAllByRole(role);
        List<FirstCategoryResult> dtoList = firstCategoryResultMapper.toDtoList(all);
        return dtoList;
    }

    @Override
    public Page<FirstCategoryResult> findAllFirstCategoryByPage(String role, String name, Pageable pageable) {
        if (StringUtils.hasText(role)) {
            return firstCategoryRepository.findAllByRole(role, pageable).map(firstCategoryResultMapper::toDto);
        } else if (StringUtils.hasText(name)) {
            return firstCategoryRepository.findAllByNameContaining(name, pageable).map(firstCategoryResultMapper::toDto);
        }
        return firstCategoryRepository.findAll(pageable).map(firstCategoryResultMapper::toDto);
    }

    @Override
    public FirstCategoryResult findById(Long id) {
        FirstCategory firstCategory = firstCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 대카테고리가 없습니다. id=" + id));
        FirstCategoryResult dto = firstCategoryResultMapper.toDto(firstCategory);
        return dto;
    }

    @Transactional
    @Override
    public Long updateFirstCategory(Long id, FirstCategoryUpdatePayload payload) {
        FirstCategory firstCategory = firstCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 대가테고리가 없습니다. id=" + id));
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
