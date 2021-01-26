package com.kt.springmvc.jakToBrac.interaction.dto;

import com.kt.springmvc.jakToBrac.product.dto.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class InteractionFood {

    Product product;
    private FoodInteraction foodInteraction;
    private List<FoodRestricted> foodRestrictedList;
    private int minDelayInHours;
}
