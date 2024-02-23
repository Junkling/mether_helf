package io.elice.shoppingmall.domain.delivery.entity;

import io.elice.shoppingmall.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Delivery extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orders_id;
    private String address;
    private String delivery_status;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;

}
