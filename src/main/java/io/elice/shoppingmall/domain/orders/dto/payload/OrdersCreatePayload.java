package io.elice.shoppingmall.domain.orders.dto.payload;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrdersCreatePayload {
    private Long userId;

    // 아이템에 대한 무언가 ?? 거의 대부분 식별자가 된다
    // 1. 아이템 ID 에 대한 리스트를 받을 것이냐 -> 아이템에서 내가 몇개 살지 정해올 수 있나??
    // 2. 장바구니 ID 리스트를 받아올 것이냐 ->
    private List<Long> cartId = new ArrayList<>();

    //어디로 배송할지도 받아와야함
    private String address;

    //지불 방법
    private String payment;
}
