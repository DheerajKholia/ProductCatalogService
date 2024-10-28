package com.ecommerce.productcatalogservice.services;


import com.ecommerce.productcatalogservice.models.Product;
import com.ecommerce.productcatalogservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> searchProducts(String query){
        return productRepo.findProductsByName(query);
    }

}