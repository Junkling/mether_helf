package io.elice.shoppingmall.domain.statuscode.service;

import io.elice.shoppingmall.domain.statuscode.dto.payload.*;
import io.elice.shoppingmall.domain.statuscode.dto.result.StatusCodeResult;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import io.elice.shoppingmall.domain.statuscode.repository.StatusCodeRepository;

import io.elice.shoppingmall.util.mapsturct.StatusCodeResultMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusCodeServiceIml implements StatusCodeService{
    private final StatusCodeRepository statusCodeRepository;
    private final StatusCodeResultMapper statusCodeResultMapper;

    @Transactional
    @Override
    public Long saveStatusCode(StatusCodeCreatePayload payload){
        StatusCode saved = statusCodeRepository.save(StatusCode.builder().name(payload.getName()).build());
        return saved.getId();
    }

    @Override
    public StatusCodeResult findStatusCode(Long id){
        StatusCode statusCode = statusCodeRepository.findById(id).orElseThrow();
        StatusCodeResult dto = statusCodeResultMapper.toDto(statusCode);
        return dto;
    }

    @Transactional
    @Override
    public Long deleteStatusCode(Long id){
        statusCodeRepository.deleteById(id);
        return id;
    }
}
