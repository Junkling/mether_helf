package io.elice.shoppingmall.domain.orders.dto.result;
import io.elice.shoppingmall.domain.item.dto.result.ItemResult;
import io.elice.shoppingmall.domain.item.entity.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrdersResult {
    private Long id;

    private String title;

    private String payment;

//    private String address;

    private Long amount;

    private List<OrderItemResult> orderItemList = new ArrayList<>();

}
