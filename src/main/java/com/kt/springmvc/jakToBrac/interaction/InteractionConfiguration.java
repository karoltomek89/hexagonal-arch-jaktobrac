package com.kt.springmvc.jakToBrac.interaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class InteractionConfiguration {

    @Bean
    InteractionFacade interactionFacade(){
        InMemoryInteractionFood inMemoryInteractionFood = new InMemoryInteractionFood();
        InMemoryInteractionDragsSuplements inMemoryInteractionDragsSuplements = new InMemoryInteractionDragsSuplements();
        return new InteractionFacade(inMemoryInteractionFood, inMemoryInteractionDragsSuplements);
    }
}
