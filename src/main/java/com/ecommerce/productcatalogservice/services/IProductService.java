package com.ecommerce.productcatalogservice.services;

import com.ecommerce.productcatalogservice.dtos.ProductDto;
import com.ecommerce.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product replaceProduct(Long id, Product product);
}
