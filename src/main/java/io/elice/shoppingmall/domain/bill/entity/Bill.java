package io.elice.shoppingmall.domain.bill.entity;

import io.elice.shoppingmall.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Bill extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bank_name;
    private Long account;
    private String depositor_name;

    private Long amount;
    private Long orders_id;

    private String bill_status;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
