package com.ecommerce.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SortParam {
    public String paramName;
    public SortType sortType;
}
