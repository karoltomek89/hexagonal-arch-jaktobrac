package com.kt.springmvc.jakToBrac.recomendation.dto;

import com.kt.springmvc.jakToBrac.interaction.dto.FoodInteraction;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Recomendation {

    final Map<Product, Set<Product>> productsEatTogether;
    final Map<Product, Set<Product>> productsEatNotTogether;
    final Map<Product, FoodInteraction> productsFoodInformation;

    public static Recomendation create(Map<Product, Set<Product>> productsEatTogether, Map<Product,
            Set<Product>> productsEatNotTogether, Map<Product,
            FoodInteraction> productsFoodInformation) {
        return new Recomendation(productsEatTogether, productsEatNotTogether, productsFoodInformation);
    }
}
