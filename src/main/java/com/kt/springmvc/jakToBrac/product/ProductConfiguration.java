package com.kt.springmvc.jakToBrac.product;

import com.kt.springmvc.jakToBrac.interaction.InteractionFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductConfiguration {

    @Bean
    ProductFacade productFacade(){
        InMemoryProductRepository inMemoryProductRepository = new InMemoryProductRepository();
        return new ProductFacade(inMemoryProductRepository);
    }
}
