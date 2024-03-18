package io.elice.shoppingmall.domain.delivery.service;

import io.elice.shoppingmall.domain.delivery.dto.payload.*;
import io.elice.shoppingmall.domain.delivery.dto.result.DeliveryResult;

import java.util.List;
public interface DeliveryService {
    Long saveDelivery(DeliveryCreatePayload payload);
    Long updateDelivery(Long id, DeliveryUpdatePayload payload);

    DeliveryResult findDelivery(Long deliveryId);

    Long deleteDelivery(Long statusCodeId);
}
