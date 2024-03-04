package io.elice.shoppingmall.domain.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class OrdersController {

    @GetMapping("/api/orders")
    public String viewOrderPage(@RequestParam Long orderId){
        return "order";
    }
}
