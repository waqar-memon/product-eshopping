package com.systems.orderservice.controllers;

import com.systems.orderservice.commons.ResponseEntity;
import com.systems.orderservice.dtos.AddOrderRequest;
import com.systems.orderservice.dtos.AddOrderResponse;
import com.systems.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<AddOrderResponse> addOrder(@RequestBody AddOrderRequest addOrderRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "accept, content-type");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        return orderService.addOrder(addOrderRequest);
    }
}