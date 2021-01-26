package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.interaction.dto.InteractionFood;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionDragsSuplements;
import com.kt.springmvc.jakToBrac.product.dto.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InteractionFacade {

    private InMemoryInteractionFood inMemoryInteractionFood;
    private InMemoryInteractionDragsSuplements inMemoryInteractionDragsSuplements;

    InteractionFacade(InMemoryInteractionFood inMemoryInteractionFood,
                      InMemoryInteractionDragsSuplements inMemoryInteractionDragsSuplements) {
        this.inMemoryInteractionFood = inMemoryInteractionFood;
        this.inMemoryInteractionDragsSuplements = inMemoryInteractionDragsSuplements;
    }

    public void addFoodInteraction(InteractionFood interactionFood){
        inMemoryInteractionFood.save(interactionFood);
    }

    public void addDragsSuplementsInteraction(InteractionDragsSuplements interactionDragsSuplements){
        inMemoryInteractionDragsSuplements.save(interactionDragsSuplements);
    }

    public List<InteractionFood> getFoodInteractions(List<Product> productList) {
        List<InteractionFood> interactionFoodList = new ArrayList<>();
        for (Product product : productList) {
            interactionFoodList
                    .add(inMemoryInteractionFood.findOneOrThrow(product.getProductName()));
        }
        return interactionFoodList;
    }

    public List<InteractionDragsSuplements> getDragSuplementInteractions(List<Product> productList) {
        List<InteractionDragsSuplements> interactionDragsSuplementsList = new ArrayList<>();
        for (Product product : productList) {
            interactionDragsSuplementsList
                    .add(inMemoryInteractionDragsSuplements.findOneOrThrow(product.getProductName()));
        }
        return interactionDragsSuplementsList;
    }

}
