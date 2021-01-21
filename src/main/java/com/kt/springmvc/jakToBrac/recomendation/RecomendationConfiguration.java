package com.kt.springmvc.jakToBrac.recomendation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RecomendationConfiguration {

    @Bean
    RecomendationFacade recomendationFacade(){
        return new RecomendationFacade();
    }
}
