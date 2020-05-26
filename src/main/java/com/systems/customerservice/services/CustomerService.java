package com.systems.customerservice.services;

import com.systems.customerservice.commons.ResponseEntity;
import com.systems.customerservice.dtos.Customer;

public interface CustomerService {
    ResponseEntity<Customer> addCustomer(Customer customer);
    ResponseEntity<Customer> getCustomerById(String customerId);
    ResponseEntity<Customer> authenticateCustomer(Customer customer);
}
