package com.kt.springmvc.jakToBrac.interaction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void importProductList() {
    }

    @Test
    void getInteractionOneProduct() {
    }

    @Test
    void getInteractionOTwoProducts() {
    }
}