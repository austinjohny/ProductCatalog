package com.austin.productcatalog.repository;

import com.austin.productcatalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Following JPA syntax, we can create a query method to find products by price range
    List<Product> findProductsByPriceBetween(double priceAfter, double priceBefore);

    // our own custom query to get the description of a product by its id
    @Query("SELECT p.description FROM Product p WHERE p.id = :id")
    String getdescriptionById(Long id);
}
