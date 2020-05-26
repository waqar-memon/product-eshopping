package com.systems.customerservice.services.impl;

import com.systems.customerservice.commons.ResponseEntity;
import com.systems.customerservice.dtos.Customer;
import com.systems.customerservice.entities.CustomerDocument;
import com.systems.customerservice.repositories.CustomerRepository;
import com.systems.customerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
//    @Autowired
//    private CustomerContactRepository customerContactRepository;
//    @Autowired
//    private CustomerAddressRepository customerAddressRepository;

    @Override
    public ResponseEntity<Customer> addCustomer(Customer customer) {
//        //save customer contact details
//        CustomerContactDocument customerContactDocument = new CustomerContactDocument();
//        customerContactDocument.setMobile(addCustomer.getMobile());
//        customerContactDocument.setLandline(addCustomer.getLandline());
//        customerContactDocument = customerContactRepository.save(customerContactDocument);
//
//        //save address details
//        CustomerAddressDocument customerAddressDocument = new CustomerAddressDocument();
//        customerAddressDocument.setCountry(addCustomer.getCountry());
//        customerAddressDocument.setCity(addCustomer.getCity());
//        customerAddressDocument.setAddress(addCustomer.getAddress());
//        customerAddressDocument = customerAddressRepository.save(customerAddressDocument);

        CustomerDocument customerDocument = new CustomerDocument();
        customerDocument.setName(customer.getName());
        customerDocument.setEmail(customer.getEmail());
        customerDocument.setPassword(customer.getPassword());
        customerDocument.setMobile(customer.getMobile());
        customerDocument.setLandline(customer.getLandline());
        customerDocument.setCountry(customer.getCountry());
        customerDocument.setCity(customer.getCity());
        customerDocument.setAddress(customer.getAddress());
//        customerDocument.setContactDetails(Collections.singletonList(customerContactDocument));
//        customerDocument.setAddressDetails(Collections.singletonList(customerAddressDocument));
        customerDocument = customerRepository.save(customerDocument);
        customer.setId(customerDocument.getId());
        return ResponseEntity.ok(customer,"Customer Added Successfully");
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(String customerId) {
        Optional<CustomerDocument> customerDocument = customerRepository.findById(customerId);
        Customer customerResponse = new Customer();
        if(customerDocument.isPresent()){
            CustomerDocument customer = customerDocument.get();
            customerResponse.setId(customer.getId());
            customerResponse.setName(customer.getName());
            customerResponse.setEmail(customer.getEmail());
            customerResponse.setMobile(customer.getMobile());
            customerResponse.setLandline(customer.getLandline());
            customerResponse.setCountry(customer.getCountry());
            customerResponse.setCity(customer.getCity());
            customerResponse.setAddress(customer.getAddress());
        }
        return ResponseEntity.ok(customerResponse, "Customer retrieved successfully");
    }

    @Override
    public ResponseEntity<Customer> authenticateCustomer(Customer customer) {
        Optional<CustomerDocument> customerDoc = customerRepository.findCustomerDocumentByEmailAndPassword(customer.getEmail(), customer.getPassword());
        Customer customerResponse = new Customer();
        if(customerDoc.isPresent()){
            CustomerDocument customerDocument = customerDoc.get();
            customerResponse.setId(customerDocument.getId());
            customerResponse.setName(customerDocument.getName());
            customerResponse.setEmail(customerDocument.getEmail());
            customerResponse.setMobile(customerDocument.getMobile());
            customerResponse.setLandline(customerDocument.getLandline());
            customerResponse.setCountry(customerDocument.getCountry());
            customerResponse.setCity(customerDocument.getCity());
            customerResponse.setAddress(customerDocument.getAddress());
            return ResponseEntity.ok(customerResponse, "Customer Authenticated Successfully.");
        }
        return ResponseEntity.forbidden(null, "Incorrect Email/Password");
    }
}