package io.elice.shoppingmall.domain.category.repository;

import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstCategoryRepository extends JpaRepository<FirstCategory, Long> {
}
