package io.elice.shoppingmall.domain.delivery.service;

import io.elice.shoppingmall.domain.delivery.dto.payload.*;
import io.elice.shoppingmall.domain.delivery.dto.result.DeliveryResult;
import io.elice.shoppingmall.domain.delivery.entity.Delivery;
import io.elice.shoppingmall.domain.delivery.repository.DeliveryRepository;
import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import io.elice.shoppingmall.domain.statuscode.repository.StatusCodeRepository;
import io.elice.shoppingmall.domain.orders.entity.Orders;
import io.elice.shoppingmall.domain.orders.repository.OrdersRepository;
import io.elice.shoppingmall.util.mapsturct.DeliveryResultMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceIml implements DeliveryService{
    private final DeliveryRepository deliveryRepository;
    private final StatusCodeRepository statusCodeRepository;
    private final OrdersRepository ordersRepository;
    private final DeliveryResultMapper deliveryResultMapper;

    @Transactional
    @Override
    public Long saveDelivery(DeliveryCreatePayload payload){
        StatusCode statusCode = statusCodeRepository.findById(payload.getId()).orElseThrow();
        Orders orders = ordersRepository.findById(payload.getId()).orElseThrow();
        Delivery saved = deliveryRepository.save(Delivery.builder().orders(orders).statusCode(statusCode).build());

        return saved.getId();
    }

    @Override
    public DeliveryResult findDelivery(Long id){
        Delivery delivery = deliveryRepository.findById(id).orElseThrow();
        DeliveryResult dto = deliveryResultMapper.toDto(delivery);
        return dto;
    }

    @Override
    public Long updateDelivery(Long id, DeliveryUpdatePayload payload) {
        Delivery delivery = deliveryRepository.findById(id).orElseThrow();
        delivery.updateDelivery(payload.getAddress(), statusCodeRepository.findById(payload.getStatusCodeId()).orElseThrow());
        return delivery.getId();
    }

    @Transactional
    @Override
    public Long deleteDelivery(Long id){
        deliveryRepository.deleteById(id);
        return id;
    }


}
