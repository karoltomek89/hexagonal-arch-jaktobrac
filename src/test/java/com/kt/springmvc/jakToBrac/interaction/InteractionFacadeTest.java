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
    void shouldFindFoodInteractionsWhenFoodInteractionsAdded() {

        //given
        Product vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);
        Product calc = createProduct("Calcium", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.CALCIUM);
        InteractionFood vitD3Food = InteractionFood.builder()
                .product(vitD3)
                .foodInteraction(FoodInteraction.WITH_MEAL)
                .minDelayInHours(0)
                .build();
        InteractionFood calcFood = InteractionFood.builder()
                .product(calc)
                .foodInteraction(FoodInteraction.WITH_MEAL)
                .minDelayInHours(0)
                .build();

        //when
        interactionFacade.addFoodInteraction(vitD3Food);
        interactionFacade.addFoodInteraction(calcFood);

        //then
        assertFalse(interactionFacade.getFoodInteractions(List.of(vitD3)).isEmpty());
        assertFalse(interactionFacade.getFoodInteractions(List.of(calc)).isEmpty());
    }

    @Test
    void shouldFindDragSuplementInteractionsWhenDragSuplementInteractionsAdded() {

        //given
        Product vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);
        Product calc = createProduct("Calcium", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.CALCIUM);
        var vitD3DragsSuplements = new InteractionDragsSuplements(vitD3,calc,InteractionType.POSITIVE);

        //when
        interactionFacade.addDragsSuplementsInteraction(vitD3DragsSuplements);

        //then
        assertFalse(interactionFacade.getDragSuplementInteractions(List.of(vitD3)).isEmpty());
    }

    @Test
    void shouldNotFindInformationWhenNoFoodInteractionsExist() {

        //given
        Product vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);

        //when then
        assertEquals(FoodInteraction.NO_INFORMATION, interactionFacade.getFoodInteractions(List.of(vitD3)).get(0).getFoodInteraction());
    }

    @Test
    void shouldFindNullWhenNoDragSuplementInteractionsAdded() {

        //given
        Product vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);

        //when then
        assertTrue(interactionFacade.getDragSuplementInteractions(List.of(vitD3)).contains(null));
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