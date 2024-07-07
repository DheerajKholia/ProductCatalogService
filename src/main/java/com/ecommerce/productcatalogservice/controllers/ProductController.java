package com.ecommerce.productcatalogservice.controllers;

import com.ecommerce.productcatalogservice.dtos.ProductDto;
import com.ecommerce.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getAllProducts(){
        List<ProductDto> products = new ArrayList<>();
        return products;
    }
    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        Product product = new Product();
        product.setId(productId);
        return null;
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return productDto;
    }
    @PutMapping("{id}")
    public ProductDto replaceProduct(@PathVariable("id") Long productId, @RequestBody ProductDto productDto){
        Product product = new Product();
        product.setId(productId);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return productDto;
    }
}
