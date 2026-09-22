package com.austin.productcatalog.services;

import com.austin.productcatalog.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {
    Page<Product> searchProducts(String query, int pageSize, int pageNumber);
}
