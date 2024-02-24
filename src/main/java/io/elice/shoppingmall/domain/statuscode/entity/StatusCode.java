package io.elice.shoppingmall.domain.statuscode.entity;

import io.elice.shoppingmall.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
