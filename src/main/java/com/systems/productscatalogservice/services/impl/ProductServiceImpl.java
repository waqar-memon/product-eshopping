package com.systems.productscatalogservice.services.impl;

import com.systems.productscatalogservice.documents.ProductDocument;
import com.systems.productscatalogservice.repository.ProductRepository;
import com.systems.productscatalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDocument>> getAllProducts() {
        List<ProductDocument> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<ProductDocument> getProductById(String productId) {
        Optional<ProductDocument> product = productRepository.findById(productId);
        return ResponseEntity.ok(product.get());
    }
}
