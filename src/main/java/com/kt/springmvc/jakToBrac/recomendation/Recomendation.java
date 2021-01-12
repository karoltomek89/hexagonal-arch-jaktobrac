package com.kt.springmvc.jakToBrac.recomendation;

import com.kt.springmvc.jakToBrac.interaction.InteractionOneProduct;
import com.kt.springmvc.jakToBrac.product.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

class Recomendation {

    List<Set<Product>> productsEatTogether;
    List<Map<Product, Integer>> productsEatOneWithDelay;
    Map<Product, Set<InteractionOneProduct> > notAllowedFoodForProduct ;

}
