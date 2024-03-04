package io.elice.shoppingmall.domain.statuscode.service;

import io.elice.shoppingmall.domain.bill.dto.payload.BillUpdatePayload;
import io.elice.shoppingmall.domain.statuscode.dto.payload.StatusCodeCreatePayload;
import io.elice.shoppingmall.domain.statuscode.dto.result.StatusCodeResult;

public interface StatusCodeService {
    //CRUD
    Long saveStatusCode(StatusCodeCreatePayload payload);

    StatusCodeResult findStatusCode(Long StatusCodeId);

    Long deleteStatusCode(Long statusCodeId);
}
