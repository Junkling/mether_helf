package io.elice.shoppingmall.domain.category.repository;

import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstCategoryRepository extends JpaRepository<FirstCategory, Long> {
    List<FirstCategory> findAllByRole(String role);
}
