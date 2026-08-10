package com.austin.productcatalog.controllers;

import com.austin.productcatalog.dtos.ProductDTO;
import com.austin.productcatalog.models.Product;
import com.austin.productcatalog.services.IProductServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    /*
    We are creating 3 API endpoints for the ProductController class:
    1. GET /products - This endpoint will return a list of all products in the catalog.
    2. GET /products/{id} - This endpoint will return a single product by its ID.
    3. POST /products - This endpoint will create a new product
     */

    IProductServices productServices;

    // we are using constructor injection here.
    // Spring will automatically inject the IProductServices implementation into this constructor.
    // Access modifier is immaterial for spring to inject the dependency,
    private ProductController(IProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/products")
    String getAllProducts() {
        return "Hello Motherfucker";
    }

    @GetMapping("/products/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        if(id < 1)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Product product = productServices.getProductById(id);
        if(product == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(product.toProductDTO(), HttpStatus.OK);
    }

    @PostMapping("/products")
    ProductDTO createProduct(ProductDTO productRequestDTO) {
        return new ProductDTO();
    }

}
