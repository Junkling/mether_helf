package io.elice.shoppingmall.domain.category.service;

import io.elice.shoppingmall.domain.category.dto.payload.SecondCategoryCreatePayload;
import io.elice.shoppingmall.domain.category.dto.payload.SecondCategoryUpdatePayload;
import io.elice.shoppingmall.domain.category.dto.result.SecondCategoryResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SecondCategoryService {

//    어떤걸 할지?  뭘 받을지? 어떤 값을 줄지?
//    CRUD
    Long saveSecondCategory(SecondCategoryCreatePayload payload);
    List<SecondCategoryResult> findSecondCategories(Long id);
    Long updateSecondCategory(Long id, SecondCategoryUpdatePayload payload);
    Long deleteSecondCategory(Long id);

//    PageNation
    Page<SecondCategoryResult> findAllSecondCategoryByPage(Long firstCategoryId, String name, Pageable pageable);

    SecondCategoryResult findSecondCategory(Long id);
}
