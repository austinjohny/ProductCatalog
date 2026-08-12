package com.austin.productcatalog.services;

import com.austin.productcatalog.client.FakeStoreClient;
import com.austin.productcatalog.dtos.FakeStoreProductDTO;
import com.austin.productcatalog.models.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductServices implements IProductServices{
    private final FakeStoreClient fakeStoreClient;

    private FakeStoreProductServices(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public Product getProductById(Long id) {
//        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/{id}",
//                FakeStoreProductDTO.class,
//                id);

        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = fakeStoreClient.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                id);

        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreProductDTOResponseEntity.getBody();
        if(fakeStoreProductDTO == null)
            return null;
        return fakeStoreProductDTO.toProduct();
    }

    /*
    Type erasure
    1. Compiling
    2. Running

    List<String>
    List<Integer>
    Java compiler check you are putting Sting instead of Integer in the list.
    But at runtime, the type information is erased and both List<String> and List<Integer> are just List.
    This is called type erasure.

    That's why we cannot use List<FakeStoreProductDTO>.class in the getForEntity method,
    because at runtime, the type information is erased, and it becomes just List.class.

    Solution: use arrays because they are reified, meaning they retain their type information at runtime.
    So we can use FakeStoreProductDTO[].class instead of List<FakeStoreProductDTO>.class.
     */
    @Override
    public List<Product> getAllProducts() {
//        ResponseEntity<List<FakeStoreProductDTO>> fakestroreProductDTOResponseEntity = restTemplate.
//                getForEntity(
//                        "https://fakestoreapi.com/products",
//                                List<FakeStoreProductDTO>.class
//                );
        ResponseEntity<FakeStoreProductDTO[]> fakestroreProductDTOResponseEntity = fakeStoreClient.
                getForEntity(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class
                );

        FakeStoreProductDTO[] fakeStoreProductDTOs = fakestroreProductDTOResponseEntity.getBody();
        if(fakeStoreProductDTOs == null)
            return null;

        List<Product> products = Arrays.stream(fakeStoreProductDTOs)
                .map(e -> e.toProduct())
                .toList();

        return products;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = fakeStoreClient.putForEntity(
                "https://fakestoreapi.com/products/{id}",
                product.toFakestoreDTO(),
                FakeStoreProductDTO.class,
                id
        );

        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreProductDTOResponseEntity.getBody();
        if(fakeStoreProductDTO == null)
            return null;

        return fakeStoreProductDTO.toProduct();
    }
}
