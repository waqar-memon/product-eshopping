package com.systems.productscatalogservice.controllers;

import com.systems.productscatalogservice.commons.ResponseEntity;
import com.systems.productscatalogservice.documents.ProductDocument;
import com.systems.productscatalogservice.dtos.Product;
import com.systems.productscatalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductsCatalogController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDocument>> getAllProducts(HttpServletResponse httpServletResponse){
        ResponseEntity<List<ProductDocument>> allProducts = productService.getAllProducts();
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "accept, content-type");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");

        return allProducts;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") String productId){
        return productService.getProductById(productId);
    }
}