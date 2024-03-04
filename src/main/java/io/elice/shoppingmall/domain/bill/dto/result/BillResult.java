package io.elice.shoppingmall.domain.bill.dto.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillResult {
    private Long billId;
    private Long ordersId;
    private Long billStatus;
}
