package com.kt.springmvc.jakToBrac.recomendation;
import com.kt.springmvc.jakToBrac.interaction.InteractionFacade;
import com.kt.springmvc.jakToBrac.interaction.dto.*;
import com.kt.springmvc.jakToBrac.product.dto.ActiveSubstanceOfSuplement;
import com.kt.springmvc.jakToBrac.product.dto.Component;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import com.kt.springmvc.jakToBrac.product.dto.ProductType;
import com.kt.springmvc.jakToBrac.recomendation.dto.Recomendation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecomendationFacadeTest {

    RecomendationFacade recomendationFacade;

    @BeforeEach
    void setUp() {
        recomendationFacade = new RecomendationConfiguration().recomendationFacade();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRecomendation() {

        //given
        var vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);
        var calc = createProduct("Calcium", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.CALCIUM);
        var omega3 = createProduct("Omega3", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.OMEGA_3_FATTY_ACID);
        List<Product> productList = List.of(vitD3,calc,omega3);

        var vitD3Food = InteractionFood.builder()
                .product(vitD3)
                .foodInteraction(FoodInteraction.WITH_MEAL)
                .minDelayInHours(0)
                .build();
        var calcFood = InteractionFood.builder()
                .product(calc)
                .foodInteraction(FoodInteraction.WITH_MEAL)
                .minDelayInHours(0)
                .build();
        var omega3Food = InteractionFood.builder()
                .product(omega3)
                .foodInteraction(FoodInteraction.WITH_MEAL)
                .minDelayInHours(0)
                .build();
        List<InteractionFood> interactionFoodList = List.of(vitD3Food,calcFood,omega3Food);

        var vitD3DragsSuplements = new InteractionDragsSuplements(vitD3,calc,InteractionType.POSITIVE);
        var omega3DragsSuplements = new InteractionDragsSuplements(vitD3,omega3,InteractionType.POSITIVE);
        var calcDragsSuplements = new InteractionDragsSuplements(calc,omega3,InteractionType.NO_INFORMATION);
        List<InteractionDragsSuplements> interactionDragsSuplementsList = List
                .of(vitD3DragsSuplements,omega3DragsSuplements,calcDragsSuplements);

        //when then
       Recomendation recomendation = recomendationFacade
               .getRecomendation(productList, interactionFoodList, interactionDragsSuplementsList);

    }

    private Product createProduct(String name, ProductType type, Component component) {
        return Product.builder().productName(name).productType(type).component(component).build();
    }
}