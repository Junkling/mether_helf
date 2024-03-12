package io.elice.shoppingmall.domain.category.repository;

import io.elice.shoppingmall.domain.category.entity.FirstCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FirstCategoryRepository extends JpaRepository<FirstCategory, Long> {
    // role로 전체조회
    List<FirstCategory> findAllByRole(String role);
    // Pagination
    Page<FirstCategory> findAllByRole(String role, Pageable pageable);

    Page<FirstCategory> findAllByNameContaining(String name, Pageable pageable);

    Optional<FirstCategory> findByName(String name);
}
