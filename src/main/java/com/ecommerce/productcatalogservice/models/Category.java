package com.ecommerce.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends BaseModel{
    private String name;
    private String description;
    private List<Product> products;
}
