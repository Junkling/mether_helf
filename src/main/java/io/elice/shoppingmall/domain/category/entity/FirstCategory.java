package io.elice.shoppingmall.domain.category.entity;

import io.elice.shoppingmall.common.BassEntity;
import io.elice.shoppingmall.domain.code.Role;
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

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    @OneToMany(mappedBy = "firstCategory")
    private List<MiddleCategory> middleCategories = new ArrayList<>();


}
