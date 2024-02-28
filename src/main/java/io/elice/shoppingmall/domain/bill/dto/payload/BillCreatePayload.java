package io.elice.shoppingmall.domain.bill.dto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillCreatePayload {
    private Long billId;
    private Long statusCodeId;
}
