package com.ecommerce.productcatalogservice.controllers;

import com.ecommerce.productcatalogservice.dtos.CategoryDto;
import com.ecommerce.productcatalogservice.dtos.ProductDto;
import com.ecommerce.productcatalogservice.models.Category;
import com.ecommerce.productcatalogservice.models.Product;
import com.ecommerce.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        List<ProductDto> productDtos=new ArrayList<>();
        List<Product> products =productService.getAllProducts();
        for(Product product:products){
            productDtos.add(from(product));
        }
        return productDtos;
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId){
        try {
            if(productId < 1){
                throw new IllegalArgumentException("Product not present");
            }
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("called by", "dev");
            Product product = productService.getProductById(productId);
            if (product == null) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(from(product),headers, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

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
        Product product = from(productDto);
        Product result = productService.replaceProduct(productId,product);
        return from(result);
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() !=null) {
            Category category = new Category();
            category.setName(productDto.getCategory().getName());
            category.setId(productDto.getCategory().getId());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto from(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory()!=null){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }
}
