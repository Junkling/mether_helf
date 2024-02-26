package io.elice.shoppingmall.domain.category.entity;

import io.elice.shoppingmall.domain.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MiddleCategory extends BassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private FirstCategory firstCategory;

}
