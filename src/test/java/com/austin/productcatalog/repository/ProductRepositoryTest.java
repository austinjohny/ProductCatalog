package com.austin.productcatalog.repository;

import com.austin.productcatalog.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    public void testJPAQuery() {
        List<Product> products = productRepository.findProductsByPriceBetween(100.0, 1000.0);
        System.out.println("Products between 100.0 and 1000.0: " + products.toString());
    }

    @Test
    @Transactional
    public void testCustomQuery() {
        String description = productRepository.getdescriptionById(1L);
        String actualDescription = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday";
        assertEquals(actualDescription, description);
    }

}