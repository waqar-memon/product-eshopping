package com.systems.orderservice.repositories;

import com.systems.orderservice.documents.ProductOrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductOrderRepository extends MongoRepository<ProductOrderDocument, String> {
}
