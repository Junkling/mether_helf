package io.elice.shoppingmall.domain.item.entity;

import io.elice.shoppingmall.domain.common.BassEntity;
import io.elice.shoppingmall.domain.category.entity.SecondCategory;
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

    public void updateItem(String name, String content, Integer price, Integer stock, Integer sellCount, Integer discountPer) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;
        this.sellCount = sellCount;
        this.discountPer = discountPer;
    }

}
