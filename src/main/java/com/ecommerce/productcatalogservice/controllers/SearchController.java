package com.ecommerce.productcatalogservice.controllers;

import com.ecommerce.productcatalogservice.dtos.SearchRequestDto;
import com.ecommerce.productcatalogservice.models.Product;
import com.ecommerce.productcatalogservice.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto){
        return  searchService.searchProducts(searchRequestDto.getQuery(), searchRequestDto.getPageNumber(), searchRequestDto.getPageLimit(), searchRequestDto.getSortParams());
    }
}
