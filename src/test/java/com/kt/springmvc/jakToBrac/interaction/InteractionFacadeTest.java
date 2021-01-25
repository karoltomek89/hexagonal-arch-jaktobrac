package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.product.dto.ActiveSubstanceOfSuplement;
import com.kt.springmvc.jakToBrac.product.dto.Component;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import com.kt.springmvc.jakToBrac.product.dto.ProductType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void shouldFindInteractions() {

        //given
        Product vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);
        Product calc = createProduct("Calcium", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.CALCIUM);
    }

    @Test
    void shouldThrowExceptionwhenInteractionNotFound() {
    }


    private Product createProduct(String name, ProductType type, Component component) {
        return new Product.ProductBuilder().withName(name).withType(type).withMainComponent(component).build();
    }
}