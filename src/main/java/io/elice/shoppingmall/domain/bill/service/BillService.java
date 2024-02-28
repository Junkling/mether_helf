package io.elice.shoppingmall.domain.bill.service;

import io.elice.shoppingmall.domain.bill.dto.payload.BillCreatePayload;
import io.elice.shoppingmall.domain.bill.dto.payload.BillUpdatePayload;
import io.elice.shoppingmall.domain.bill.dto.result.BillResult;

import java.util.List;
public interface BillService {

    //CRUD
    Long saveBill(BillCreatePayload payload);

    BillResult findBill(Long billId);

    Long deleteBill(Long billId);

}
