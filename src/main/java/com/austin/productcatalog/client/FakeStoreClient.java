package com.austin.productcatalog.client;

import com.austin.productcatalog.dtos.FakeStoreProductDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {
    @Autowired
    RestTemplate restTemplate;

    public <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }


    public <T> ResponseEntity<T> getForEntity(String url, Class<T> fakeStoreProductDTOClass, Object... uriVariables) {
        return restTemplate.getForEntity(url, fakeStoreProductDTOClass, uriVariables);
    }


}
