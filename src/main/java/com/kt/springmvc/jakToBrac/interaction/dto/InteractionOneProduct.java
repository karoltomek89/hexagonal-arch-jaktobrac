package com.kt.springmvc.jakToBrac.interaction.dto;

import com.kt.springmvc.jakToBrac.product.dto.Product;
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
    private int minDelayInHours;
}
