package io.elice.shoppingmall.domain.orders.entity;

import io.elice.shoppingmall.domain.cart.entity.Cart;
import io.elice.shoppingmall.domain.common.BassEntity;
import io.elice.shoppingmall.domain.bill.entity.Bill;
import io.elice.shoppingmall.domain.delivery.entity.Delivery;
import io.elice.shoppingmall.domain.item.entity.Item;
import io.elice.shoppingmall.domain.orderitem.entity.OrderItem;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import io.elice.shoppingmall.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Orders extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    // 뭐 생각하고 만든 필드냐면 대표상품명 같은걸 만들려고 넣은애
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusCode statusCode;

    private Long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(mappedBy = "orders")
    private Delivery delivery;

    @OneToOne(mappedBy = "orders")
    private Bill bill;

    private String payment;

    @BatchSize(size = 50)
    @OneToMany(mappedBy = "orders", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<OrderItem> orderItemList = new ArrayList<>();


    public void increaseAmount(Integer amount) {
        this.amount += (long)amount;
    }

    public void updateOrders(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public void setTitleName(List<Cart> cartList) {
        this.title = cartList.get(0).getItem().getName() + " 등 " + cartList.size() +" 개";
    }
}
