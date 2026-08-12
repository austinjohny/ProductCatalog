package com.austin.productcatalog.services;

import com.austin.productcatalog.models.Product;

import java.util.List;

/*
Service layer must not be tightly coupled to the data access layer.
This is why we are using an interface here.
 */

public interface IProductServices {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
}
