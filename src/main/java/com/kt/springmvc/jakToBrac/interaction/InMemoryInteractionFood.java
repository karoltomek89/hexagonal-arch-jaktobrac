package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.interaction.dto.InteractionFood;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryInteractionFood {

    private ConcurrentHashMap<String, InteractionFood> map = new ConcurrentHashMap<>();

    InteractionFood save(InteractionFood interaction) {
        requireNonNull(interaction);
        map.put(interaction.toString(), interaction);
        return interaction;
    }

    InteractionFood findOneOrThrow(String name) {
        InteractionFood interaction = map.get(name);
        if (interaction == null) {
            throw new InteractionWithFoodtNotFoundException(name);
        }
        return interaction;
    }

    void delete(String name) {
        map.remove(name);
    }

    class InteractionWithFoodtNotFoundException extends RuntimeException {
        public InteractionWithFoodtNotFoundException(String title) {
            super("No interaction of name \"" + title + "\" found", null, false, false);
        }
    }
    
}
