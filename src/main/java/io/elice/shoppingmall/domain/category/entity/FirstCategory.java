package io.elice.shoppingmall.domain.category.entity;

import io.elice.shoppingmall.common.BassEntity;
import io.elice.shoppingmall.domain.code.Role;
import jakarta.persistence.*;
import lombok.*;

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

}
