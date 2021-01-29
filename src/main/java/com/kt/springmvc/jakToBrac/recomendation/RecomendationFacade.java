package com.kt.springmvc.jakToBrac.recomendation;

import com.kt.springmvc.jakToBrac.interaction.dto.InteractionFood;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionDragsSuplements;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import com.kt.springmvc.jakToBrac.recomendation.dto.Recomendation;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class RecomendationFacade {

    public Recomendation getRecomendation(
            List<Product> productList,
            List<InteractionFood> interactionFoodList,
            List<InteractionDragsSuplements> interactionDragsSuplementsList) {

        requireNonNull(productList);
        requireNonNull(interactionFoodList);
        requireNonNull(interactionDragsSuplementsList);

        return RecomendationCreator.createRecomendation(productList, interactionDragsSuplementsList, interactionFoodList);
    }
}
