package com.systems.productscatalogservice.controllers;

import com.systems.productscatalogservice.documents.ProductDocument;
import com.systems.productscatalogservice.dtos.Product;
import com.systems.productscatalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsCatalogController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDocument>> getAllProducts(){
        ResponseEntity<List<ProductDocument>> allProducts = productService.getAllProducts();
        return allProducts;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ResponseEntity<ProductDocument> getProductById(@PathVariable("productId") String productId){
        return productService.getProductById(productId);
    }
}