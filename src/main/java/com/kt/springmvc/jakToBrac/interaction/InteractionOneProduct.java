package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class InteractionOneProduct {

    Product product;
    private FoodInteraction foodInteraction;
    private List<FoodRestricted> foodRestrictedList;
}
