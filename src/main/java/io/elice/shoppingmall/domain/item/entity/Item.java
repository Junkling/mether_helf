package io.elice.shoppingmall.domain.item.entity;

import io.elice.shoppingmall.domain.category.entity.SecondCategory;
import io.elice.shoppingmall.domain.common.BassEntity;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Item extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private SecondCategory secondCategory;

    private String name;

    private Integer price;

    private Integer stock;

    // 상품설명 넣을 것 인가?
    private String content;

    private Integer sellCount;

    private Integer discountPer;

    public void updateItem(String name, String content, Integer price, Integer stock, Integer discountPer, SecondCategory secondCategory) {
        this.secondCategory = secondCategory;
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;
        this.discountPer = discountPer;
    }

    @PrePersist
    public void init() {
        this.sellCount = 0;
    }
    public void sell(Integer sellCount) {
        if (stock - sellCount < 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.stock -= sellCount;
        this.sellCount += sellCount;
    }

}
