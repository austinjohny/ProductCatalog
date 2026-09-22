package com.austin.productcatalog.services;

import com.austin.productcatalog.models.Product;
import com.austin.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> searchProducts(String query, int pageSize, int pageNumber) {
        Sort sortByPrice = Sort.by("price").descending();
        Sort sortByIdDesc = Sort.by("id").descending();
        Sort sort = sortByPrice.and(sortByIdDesc);
        return productRepository.findProductsByNameContaining(query, PageRequest.of(pageNumber, pageSize, sort));
    }
}
