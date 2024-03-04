package io.elice.shoppingmall.domain.delivery.entity;

import io.elice.shoppingmall.domain.common.BassEntity;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import io.elice.shoppingmall.domain.statuscode.repository.StatusCodeRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Delivery extends BassEntity {

    @Autowired
    private StatusCodeRepository statusCodeRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Orders orders;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusCode statusCode;

    @PrePersist
    private void setStatusCode() {
        this.statusCode = statusCodeRepository.findById(1L).orElseThrow();
    }

}
