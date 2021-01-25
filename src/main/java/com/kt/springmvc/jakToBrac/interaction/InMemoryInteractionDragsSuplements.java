package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.interaction.dto.InteractionDragsSuplements;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryInteractionDragsSuplements {

    private ConcurrentHashMap<String, InteractionDragsSuplements> map = new ConcurrentHashMap<>();

    InteractionDragsSuplements save(InteractionDragsSuplements interaction) {
        requireNonNull(interaction);
        map.put(interaction.toString(), interaction);
        return interaction;
    }

    InteractionDragsSuplements findOneOrThrow(String name) {
        InteractionDragsSuplements interaction = map.get(name);
        if (interaction == null) {
            throw new InMemoryInteractionDragsSuplements.InteractionTwoProductsNotFoundException(name);
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
