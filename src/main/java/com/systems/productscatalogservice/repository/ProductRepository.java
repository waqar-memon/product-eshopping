package com.systems.productscatalogservice.repository;

import com.systems.productscatalogservice.documents.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDocument, String> {
}
