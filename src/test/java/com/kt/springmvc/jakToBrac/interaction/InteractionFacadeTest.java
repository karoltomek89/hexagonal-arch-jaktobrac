package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.interaction.dto.*;
import com.kt.springmvc.jakToBrac.product.dto.ActiveSubstanceOfSuplement;
import com.kt.springmvc.jakToBrac.product.dto.Component;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import com.kt.springmvc.jakToBrac.product.dto.ProductType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InteractionFacadeTest {

    InteractionFacade interactionFacade;

    @BeforeEach
    void setUp() {
        interactionFacade = new InteractionConfiguration().interactionFacade();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldFindInteractionsWhenInteractionsAdded() {

        //given
        Product vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);
        Product calc = createProduct("Calcium", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.CALCIUM);
        InteractionFood vitD3Food = InteractionFood.builder()
                .product(vitD3)
                .foodInteraction(FoodInteraction.WITH_MEAL)
                .minDelayInHours(0)
                .build();
        InteractionFood calcFood = InteractionFood.builder()
                .product(vitD3)
                .foodInteraction(FoodInteraction.WITH_MEAL)
                .minDelayInHours(0)
                .build();

        var vitD3DragsSuplements = new InteractionDragsSuplements(vitD3,calc,InteractionType.POSITIVE);

        //when
        interactionFacade.addFoodInteraction(vitD3Food);
        interactionFacade.addFoodInteraction(calcFood);
        interactionFacade.addDragsSuplementsInteraction(vitD3DragsSuplements);

        //then
        assertFalse(interactionFacade.getFoodInteractions(List.of(vitD3)).isEmpty());
    }


    private Product createProduct(String name, ProductType type, Component component) {
        return Product.builder().productName(name).productType(type).component(component).build();
    }

    private InteractionDragsSuplements createDragsSuplementsInteraction(
            Product productA, Product productB, InteractionType interactionType){
        return new InteractionDragsSuplements(productA, productB, interactionType);
    }

    private InteractionFood createFoodInteraction(
            Product product, FoodInteraction foodInteraction, List<FoodRestricted> foodRestrictedList,int minDelayInHours){
        return InteractionFood.builder()
                .product(product)
                .foodInteraction(foodInteraction)
                .foodRestrictedList(foodRestrictedList)
                .minDelayInHours(minDelayInHours).build();
    }
}