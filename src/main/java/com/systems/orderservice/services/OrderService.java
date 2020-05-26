package com.systems.orderservice.services;

import com.systems.orderservice.commons.ResponseEntity;
import com.systems.orderservice.dtos.AddOrderRequest;
import com.systems.orderservice.dtos.AddOrderResponse;

public interface OrderService {
    ResponseEntity<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest);
}
