package com.ecommerce.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {
    private String query;
    private Integer pageLimit;
    private Integer pageNumber;
}
