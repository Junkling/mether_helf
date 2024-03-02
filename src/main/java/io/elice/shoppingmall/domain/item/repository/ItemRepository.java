package io.elice.shoppingmall.domain.item.repository;

import io.elice.shoppingmall.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllBySecondCategoryId(Long secondCategoryId);
}
