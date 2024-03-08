package io.elice.shoppingmall.domain.category.entity;

import io.elice.shoppingmall.domain.category.dto.payload.FirstCategoryUpdatePayload;
import io.elice.shoppingmall.domain.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FirstCategory extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Enumerated(EnumType.STRING)
    private String role;

    private String name;

    @OneToMany(mappedBy = "firstCategory", cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<SecondCategory> secondCategoryList = new ArrayList<>();

    public void updateFirstCategory(FirstCategoryUpdatePayload payload) {
        this.role = payload.getRole();
        this.name = payload.getName();
    }

}
