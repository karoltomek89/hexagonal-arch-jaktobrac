package com.kt.springmvc.jakToBrac.recomendation;

import com.kt.springmvc.jakToBrac.interaction.dto.FoodInteraction;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionDragsSuplements;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionFood;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import com.kt.springmvc.jakToBrac.recomendation.dto.Recomendation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class RecomendationCreator {

    static Map<Product, Set<Product>> checkTogether(List<Product> productList,
                                                    List<InteractionDragsSuplements> interactionDragsSuplementsList) {
        return null;
    }

    static Map<Product, Set<Product>> checkNotTogether(List<Product> productList,
                                                       List<InteractionDragsSuplements> interactionDragsSuplementsList) {
        return null;
    }

    static Map<Product, FoodInteraction> checkFilterFodInteractions(List<InteractionFood> interactionFoodList) {
        return null;
    }

    static Recomendation createRecomendation(List<Product> productList,
                                             List<InteractionDragsSuplements> interactionDragsSuplementsList,
                                             List<InteractionFood> interactionFoodList) {

        Map<Product, Set<Product>> productsEatTogether = checkTogether(productList, interactionDragsSuplementsList);
        Map<Product, Set<Product>> productsEatNotTogether = checkNotTogether(productList, interactionDragsSuplementsList);
        Map<Product, FoodInteraction> productsFoodInformation = checkFilterFodInteractions(interactionFoodList);

        return Recomendation.create(productsEatTogether, productsEatNotTogether, productsFoodInformation);

    }

}
