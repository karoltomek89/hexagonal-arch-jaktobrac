package com.kt.springmvc.jakToBrac.recomendation;
;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void importInteractionTwoProductsList() {
    }

    @Test
    void importInteractionOneProductList() {
    }

    @Test
    void getRecomendation() {
    }
}