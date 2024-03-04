package io.elice.shoppingmall.domain.bill.service;

import io.elice.shoppingmall.domain.bill.dto.payload.BillCreatePayload;
import io.elice.shoppingmall.domain.bill.dto.payload.BillUpdatePayload;
import io.elice.shoppingmall.domain.bill.dto.result.BillResult;
import io.elice.shoppingmall.domain.bill.entity.Bill;
import io.elice.shoppingmall.domain.bill.repository.BillRepository;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import io.elice.shoppingmall.domain.statuscode.repository.StatusCodeRepository;
import io.elice.shoppingmall.util.mapsturct.BillResultMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceIml implements BillService {
    private final BillRepository billRepository;
    private final StatusCodeRepository statusCodeRepository;
    private final BillResultMapper billResultMapper;

    @Transactional
    @Override
    public Long saveBill(BillCreatePayload payload){
        StatusCode status = statusCodeRepository.findById(payload.getStatusCodeId()).orElseThrow();
        Bill saved = billRepository.save(Bill.builder().statusCode(status).build());

        return saved.getId();
    }

    @Override
    public BillResult findBill(Long id){
        Bill bill = billRepository.findById(id).orElseThrow();
        BillResult dto = billResultMapper.toDto(bill);
        return dto;
    }

    @Transactional
    @Override
    public Long deleteBill(Long id){
        billRepository.deleteById(id);
        return id;
    }

}
