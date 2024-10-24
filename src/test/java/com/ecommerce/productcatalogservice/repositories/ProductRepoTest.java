package com.ecommerce.productcatalogservice.repositories;

import com.ecommerce.productcatalogservice.models.Category;
import com.ecommerce.productcatalogservice.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    void testJPAQueries() {
        List<Product> products = productRepo.findProductsByPriceBetween(6499D, 70000D);
        System.out.println(productRepo.findCategoryNameFromProductId(5L));
    }

    public void insertIntoAWSDb() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Headphones");
        product.setDescription("Wireless headphones compatible with android and ios");
        Category category = new Category();
        category.setId(2L);
        category.setName("Headphones");
        product.setCategory(category);
        productRepo.save(product);
    }
}