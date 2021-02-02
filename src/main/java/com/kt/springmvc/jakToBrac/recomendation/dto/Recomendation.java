package com.kt.springmvc.jakToBrac.recomendation.dto;

import com.kt.springmvc.jakToBrac.interaction.dto.FoodInteraction;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionFood;
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
    final Map<Product, InteractionFood> productsFoodInformation;

    public static Recomendation create(Map<Product, Set<Product>> productsEatTogether,
                                       Map<Product, Set<Product>> productsEatNotTogether,
                                       Map<Product, InteractionFood> productInteractionFood) {
        return new Recomendation(productsEatTogether, productsEatNotTogether, productInteractionFood);
    }
}
