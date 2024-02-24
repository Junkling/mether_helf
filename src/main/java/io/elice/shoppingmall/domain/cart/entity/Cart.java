package io.elice.shoppingmall.domain.cart.entity;

import io.elice.shoppingmall.common.BassEntity;
import io.elice.shoppingmall.domain.item.entity.Item;
import io.elice.shoppingmall.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Cart extends BassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Item item;

}
