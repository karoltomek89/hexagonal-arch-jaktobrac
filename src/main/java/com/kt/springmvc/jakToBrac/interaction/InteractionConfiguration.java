package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.product.ProductFacade;
import com.kt.springmvc.jakToBrac.recomendation.RecomendationFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class InteractionConfiguration {

    @Bean
    InteractionFacade interactionFacade(){
        return new InteractionFacade();
    }


}
