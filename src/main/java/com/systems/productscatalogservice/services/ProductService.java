package com.systems.productscatalogservice.services;

import com.systems.productscatalogservice.documents.ProductDocument;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<List<ProductDocument>> getAllProducts();
    ResponseEntity<ProductDocument> getProductById(String productId);
}
