package com.austin.productcatalog.services;

import com.austin.productcatalog.dtos.FakeStoreProductDTO;
import com.austin.productcatalog.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServices implements IProductServices{
    RestTemplate restTemplate;

    private FakeStoreProductServices(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
//        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/{id}",
//                FakeStoreProductDTO.class,
//                id);

        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                id);

        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreProductDTOResponseEntity.getBody();
        if(fakeStoreProductDTO == null)
            return null;
        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
