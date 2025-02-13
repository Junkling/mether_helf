package io.elice.shoppingmall.domain.category.repository;

import io.elice.shoppingmall.domain.category.entity.SecondCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondCategoryRepository extends JpaRepository<SecondCategory, Long> {
    List<SecondCategory> findByFirstCategoryId(Long id);

    Page<SecondCategory> findByNameContaining(String name, Pageable pageable);

    Page<SecondCategory> findByFirstCategoryId(Long id, Pageable pageable);
}
