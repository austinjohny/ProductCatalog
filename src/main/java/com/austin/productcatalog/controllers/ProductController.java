package com.austin.productcatalog.controllers;

import com.austin.productcatalog.dtos.ProductRequestDTO;
import com.austin.productcatalog.dtos.ProductResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    /*
    We are creating 3 endpoints for the ProductController class:
    1. GET /products - This endpoint will return a list of all products in the catalog.
    2. GET /products/{id} - This endpoint will return a single product by its ID.
    3. POST /products - This endpoint will create a new product
     */

    @GetMapping("/products")
    String getAllProducts() {
        return "Hello Motherfucker";
    }

    @GetMapping("/products/{id}")
    ProductResponseDTO getProductById(@PathVariable("id") Long id) {
        return new ProductResponseDTO();
    }

    @PostMapping("/products")
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return new ProductResponseDTO();
    }

}
