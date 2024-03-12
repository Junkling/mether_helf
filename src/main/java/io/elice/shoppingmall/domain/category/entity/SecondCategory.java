package io.elice.shoppingmall.domain.category.entity;

import io.elice.shoppingmall.domain.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SecondCategory extends BassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "first_category_id")
    private FirstCategory firstCategory;

    public void updateSecondCategory(String name, FirstCategory firstCategory) {
        this.name = name;
        this.firstCategory = firstCategory;
    }

}
