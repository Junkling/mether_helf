package io.elice.shoppingmall.domain.statuscode.entity;

import io.elice.shoppingmall.domain.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class StatusCode extends BassEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
