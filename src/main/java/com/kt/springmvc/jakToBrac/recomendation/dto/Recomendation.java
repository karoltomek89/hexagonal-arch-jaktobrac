package com.kt.springmvc.jakToBrac.recomendation.dto;

import com.kt.springmvc.jakToBrac.interaction.dto.InteractionOneProduct;
import com.kt.springmvc.jakToBrac.product.dto.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Recomendation {

    List<Set<Product>> productsEatTogether;
    List<Map<Product, Integer>> productsEatOneWithDelay;
    Map<Product, Set<InteractionOneProduct> > notAllowedFoodForProduct ;

}
