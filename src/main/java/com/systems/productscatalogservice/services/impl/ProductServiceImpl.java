package com.systems.productscatalogservice.services.impl;

import com.systems.productscatalogservice.commons.ResponseEntity;
import com.systems.productscatalogservice.documents.ProductDocument;
import com.systems.productscatalogservice.dtos.Product;
import com.systems.productscatalogservice.repository.ProductRepository;
import com.systems.productscatalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(products, "Products retrieved successfully");
    }

    @Override
    public ResponseEntity<Product> getProductById(String productId) {
        Optional<ProductDocument> productDocument = productRepository.findById(productId);
        Product productResponse = new Product();
        if(productDocument.isPresent()){
            ProductDocument product = productDocument.get();
            productResponse.setProductId(product.getProductId());
            productResponse.setProductName(product.getProductName());
            productResponse.setProductPrice(product.getProductPrice());
        }
        return ResponseEntity.ok(productResponse, "Product retrieved successfully");
    }
}
