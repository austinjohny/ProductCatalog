package com.austin.productcatalog.services;

import com.austin.productcatalog.models.Product;
import com.austin.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("productStorageService")
public class ProductStorageService implements IProductServices{
    private final ProductRepository productRepository;

    public ProductStorageService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        if(getProductById(id) == null)
            return null;
        product.setId(id);
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> addProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }
}

/* After adding this service, controller will be confused which service to use
So, there are two ways to solve this problem:
1. Use @Primary annotation on one of the service classes to indicate that it should be used as the default implementation of the interface.
2. Use @Qualifier annotation on the constructor parameter to specify which implementation of the interface should be injected.
 */
