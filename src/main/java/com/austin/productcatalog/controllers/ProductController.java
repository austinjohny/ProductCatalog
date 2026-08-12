package com.austin.productcatalog.controllers;

import com.austin.productcatalog.dtos.ProductDTO;
import com.austin.productcatalog.models.Product;
import com.austin.productcatalog.services.IProductServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
    ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        List<Product> products = productServices.getAllProducts();

        if(products.isEmpty())
            throw new NoSuchElementException("Nothing inside the product catalog");

        List<ProductDTO> productDTOList = products.stream()
                .map(e -> e.toProductDTO())
                .toList();
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        if(id < 1)
            throw new IllegalArgumentException("id must be greater than 0");

        Product product = productServices.getProductById(id);
        if(product == null)
            throw new NoSuchElementException("Product with id " + id + " not found");

        return new ResponseEntity<>(product.toProductDTO(), HttpStatus.OK);
    }

    /*
    This will not actually update the website, but just to show how this works
    So after update if you check GET /products/{id} you will see the old product
    */
    @PutMapping("/products/{id}")
    ResponseEntity<ProductDTO> createProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        if(id < 1)
            throw new IllegalArgumentException("id must be greater than 0");

        Product product = productServices.replaceProduct(id, productDTO.toProduct());

        if(product == null)
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(product.toProductDTO(), HttpStatus.CREATED);
    }

}
