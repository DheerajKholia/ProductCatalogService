package com.ecommerce.productcatalogservice.controllers;

import com.ecommerce.productcatalogservice.dtos.ProductDto;
import com.ecommerce.productcatalogservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductControllerFlow {

    @Autowired
    private ProductController productController;

    @Autowired
    private IProductService productService;

    @Test
    public void Test_Create_Replace_GetProduct_RunsSuccessfully() {
        //Arrange
        ProductDto productDto = new ProductDto();
        productDto.setName("Iphone15");
        productDto.setId(10L);

        //Act
        ProductDto response = productController.createProduct(productDto);
        ProductDto  responseEntity = productController.getProduct(response.getId()).getBody();
        productDto.setName("Iphone20");
        ProductDto response2  = productController.replaceProduct(response.getId(),productDto);
        ProductDto responseEntity2 = productController.getProduct(response2.getId()).getBody();


        //Assert
        assertEquals("Iphone15",responseEntity.getName());
        assertEquals("Iphone20",responseEntity2.getName());
    }
}
