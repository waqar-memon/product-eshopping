package com.systems.customerservice.repositories;

import com.systems.customerservice.entities.CustomerAddressDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerAddressRepository extends MongoRepository<CustomerAddressDocument, String> {
}
