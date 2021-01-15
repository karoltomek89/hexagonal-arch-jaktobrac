package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.interaction.dto.InteractionTwoProducts;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryInteractionRepositoryTwoProducts {

    private ConcurrentHashMap<String, InteractionTwoProducts> map = new ConcurrentHashMap<>();

    InteractionTwoProducts save(InteractionTwoProducts interaction) {
        requireNonNull(interaction);
        map.put(interaction.toString(), interaction);
        return interaction;
    }

    InteractionTwoProducts findOneOrThrow(String name) {
        InteractionTwoProducts interaction = map.get(name);
        if (interaction == null) {
            throw new InMemoryInteractionRepositoryTwoProducts.InteractionTwoProductsNotFoundException(name);
        }
        return interaction;
    }

    void delete(String name) {
        map.remove(name);
    }

    class InteractionTwoProductsNotFoundException extends RuntimeException {
        public InteractionTwoProductsNotFoundException(String title) {
            super("No interaction of name \"" + title + "\" found", null, false, false);
        }
    }
    
}
