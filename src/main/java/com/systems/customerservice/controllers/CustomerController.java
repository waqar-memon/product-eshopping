package com.systems.customerservice.controllers;

import com.systems.customerservice.commons.ResponseEntity;
import com.systems.customerservice.dtos.Customer;
import com.systems.customerservice.entities.CustomerDocument;
import com.systems.customerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/find/email/{email}")
    public ResponseEntity<CustomerDocument> getCustomerByEmail(@PathVariable("email") String email){
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer, HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "accept, content-type");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") String customerId){
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Customer> authenticateCustomer(@RequestBody Customer customer, HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "accept, content-type");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        return customerService.authenticateCustomer(customer);
    }
}