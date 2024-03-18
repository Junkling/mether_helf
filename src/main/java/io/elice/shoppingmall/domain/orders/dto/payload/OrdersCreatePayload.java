package io.elice.shoppingmall.domain.orders.dto.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrdersCreatePayload {
    private Long userId;

    private List<Long> cartId = new ArrayList<>();

    @NotEmpty
    private String address;

    @NotEmpty
    private String payment;

    @NotNull
    private Long statusId;
}
