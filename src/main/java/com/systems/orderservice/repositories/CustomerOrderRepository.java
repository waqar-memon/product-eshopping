package com.systems.orderservice.repositories;

import com.systems.orderservice.documents.CustomerOrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerOrderRepository extends MongoRepository<CustomerOrderDocument, String> {
}
