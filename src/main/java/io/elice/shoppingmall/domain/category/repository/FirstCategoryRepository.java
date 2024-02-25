package io.elice.shoppingmall.domain.category.repository;

import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstCategoryRepository extends JpaRepository<FirstCategory, Long> {
}
