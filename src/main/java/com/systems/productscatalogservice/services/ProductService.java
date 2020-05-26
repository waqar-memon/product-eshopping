package com.systems.productscatalogservice.services;

import com.systems.productscatalogservice.commons.ResponseEntity;
import com.systems.productscatalogservice.documents.ProductDocument;
import com.systems.productscatalogservice.dtos.Product;

import java.util.List;

public interface ProductService {
    ResponseEntity<List<ProductDocument>> getAllProducts();
    ResponseEntity<Product> getProductById(String productId);
}
