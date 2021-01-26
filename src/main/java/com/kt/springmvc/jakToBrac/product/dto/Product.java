package com.kt.springmvc.jakToBrac.product.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Product {

    private String productName;
    private ProductType productType;
    private Component component;
    private List<Component> otherComponentList;

}
