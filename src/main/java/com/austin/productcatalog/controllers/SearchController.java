package com.austin.productcatalog.controllers;

import com.austin.productcatalog.dtos.ProductDTO;
import com.austin.productcatalog.dtos.SearchRequestDTO;
import com.austin.productcatalog.dtos.SearchResponseDTO;
import com.austin.productcatalog.models.Product;
import com.austin.productcatalog.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private ISearchService searchService;

    @PostMapping()
    public ResponseEntity<Page<ProductDTO>> searchProducts(@RequestBody SearchRequestDTO searchRequestDTO){
        Page<Product> products = searchService.searchProducts(searchRequestDTO.getQuery(), searchRequestDTO.getPageSize(), searchRequestDTO.getPageNumber());

        Page<ProductDTO> productDTOS = products.map(p -> p.toProductDTO());

        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }
}
