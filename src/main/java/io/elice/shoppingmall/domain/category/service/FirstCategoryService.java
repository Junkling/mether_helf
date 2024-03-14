package io.elice.shoppingmall.domain.category.service;

import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryCreatePayload;
import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryUpdatePayload;
import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryDetailResult;
import io.elice.shoppingmall.domain.category.dto.result.FirstCategoryResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FirstCategoryService {

//     어떤걸 할지?  뭘 받을지? 어떤 값을 줄지?
//     CRUD

    Long saveFirstCategory(FirstCategoryCreatePayload payload);
    List<FirstCategoryResult> findFirstCategories(String role);
    Page<FirstCategoryResult> findAllFirstCategoryByPage(String role, String name, Pageable pageable);
    FirstCategoryResult findById(Long firstCategoryId);
    Long updateFirstCategory(Long id, FirstCategoryUpdatePayload payload);
    Long deleteFirstCategory(Long id);
}
