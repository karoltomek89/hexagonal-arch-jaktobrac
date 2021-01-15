package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.interaction.dto.InteractionOneProduct;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryInteractionRepositoryOneProduct {

    private ConcurrentHashMap<String, InteractionOneProduct> map = new ConcurrentHashMap<>();

    InteractionOneProduct save(InteractionOneProduct interaction) {
        requireNonNull(interaction);
        map.put(interaction.toString(), interaction);
        return interaction;
    }

    InteractionOneProduct findOneOrThrow(String name) {
        InteractionOneProduct interaction = map.get(name);
        if (interaction == null) {
            throw new InMemoryInteractionRepositoryOneProduct.InteractionOneProductNotFoundException(name);
        }
        return interaction;
    }

    void delete(String name) {
        map.remove(name);
    }

    class InteractionOneProductNotFoundException extends RuntimeException {
        public InteractionOneProductNotFoundException(String title) {
            super("No interaction of name \"" + title + "\" found", null, false, false);
        }
    }
    
}
