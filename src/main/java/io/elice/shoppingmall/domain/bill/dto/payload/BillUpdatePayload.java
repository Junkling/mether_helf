package io.elice.shoppingmall.domain.bill.dto.payload;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillUpdatePayload {
    private Long billId;
    private Long ordersId;
    private Long billStatus;
}
