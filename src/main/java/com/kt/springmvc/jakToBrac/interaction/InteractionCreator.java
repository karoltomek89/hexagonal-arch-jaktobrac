package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.product.Product;

import java.util.List;

class InteractionCreator {

    InteractionTwoProducts createInteractionTwoProducts(Product productA, Product productB) {
        return new InteractionTwoProducts(productA, productB, InteractionType.NO_INFORMATION, 0);
    }

    InteractionOneProduct createInteractionOneProduct(Product product) {
        return new InteractionOneProduct(product, FoodInteraction.WITH_MEAL, List.of(FoodRestricted.CITRUSES));
    }


}
