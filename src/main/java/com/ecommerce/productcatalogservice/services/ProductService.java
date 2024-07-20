package com.ecommerce.productcatalogservice.services;

import com.ecommerce.productcatalogservice.dtos.FakeStoreProductDto;
import com.ecommerce.productcatalogservice.models.Category;
import com.ecommerce.productcatalogservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("http://fakestoreapi.com/products/{productId}", FakeStoreProductDto.class, id);
        if(fakeStoreProductDtoResponseEntity.getBody()!=null &&
                fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatus.OK)){
            return from(fakeStoreProductDtoResponseEntity.getBody());
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}