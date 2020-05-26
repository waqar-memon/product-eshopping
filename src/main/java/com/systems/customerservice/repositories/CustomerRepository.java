package com.systems.customerservice.repositories;

import com.systems.customerservice.entities.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerDocument, String> {
    Optional<CustomerDocument> findCustomerDocumentByEmailAndPassword(String email, String password);
}
