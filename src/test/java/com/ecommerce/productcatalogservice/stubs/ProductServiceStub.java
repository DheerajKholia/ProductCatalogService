package com.ecommerce.productcatalogservice.stubs;

import com.ecommerce.productcatalogservice.models.Product;
import com.ecommerce.productcatalogservice.services.IProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceStub implements IProductService {
    Map<Long, Product> productMap;

    public ProductServiceStub() {
        this.productMap = new HashMap<>();
    }


    @Override
    public Product getProductById(Long id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return (List)productMap.values();
    }

    @Override
    public Product createProduct(Product product) {
        productMap.put(product.getId(),product);
        return productMap.get(product.getId());
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        productMap.put(id,product);
        return productMap.get(id);
    }
}