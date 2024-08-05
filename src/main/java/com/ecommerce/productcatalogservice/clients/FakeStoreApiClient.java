package com.ecommerce.productcatalogservice.clients;

import com.ecommerce.productcatalogservice.dtos.FakeStoreProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreApiClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductDto getProductById(Long id){
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=requestForEntity(HttpMethod.GET,"http://fakestoreapi.com/products/{productId}",null, FakeStoreProductDto.class, id);
        if(fakeStoreProductDtoResponseEntity.getBody()!=null &&
                fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatus.OK)){
            return fakeStoreProductDtoResponseEntity.getBody();
        }
        return null;

    }
    public FakeStoreProductDto replaceProduct(Long id,FakeStoreProductDto fakeStoreProductDtoReq) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = requestForEntity(HttpMethod.PUT,"http://fakestoreapi.com/products/{productId}",fakeStoreProductDtoReq,FakeStoreProductDto.class,id).getBody();
        return fakeStoreProductDto;
    }
    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
