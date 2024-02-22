package io.elice.shoppingmall.domain.category.repository;

import io.elice.shoppingmall.domain.category.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory, Long> {
}
