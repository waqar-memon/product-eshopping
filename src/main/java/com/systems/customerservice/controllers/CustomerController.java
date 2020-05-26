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

    @RequestMapping(value = "/find/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<CustomerDocument> getCustomerByEmail(@PathVariable("email") String email){
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer, HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "accept, content-type");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        return customerService.addCustomer(customer);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") String customerId){
        return customerService.getCustomerById(customerId);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<Customer> authenticateCustomer(@RequestBody Customer customer, HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "accept, content-type");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        return customerService.authenticateCustomer(customer);
    }
}