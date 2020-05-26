package com.systems.customerservice.repositories;

import com.systems.customerservice.entities.CustomerContactDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerContactRepository extends MongoRepository<CustomerContactDocument, String> {
}
