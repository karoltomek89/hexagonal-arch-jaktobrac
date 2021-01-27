package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.interaction.dto.FoodInteraction;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionDragsSuplements;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionFood;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryInteractionDragsSuplements {

    private ConcurrentHashMap<String, InteractionDragsSuplements> map = new ConcurrentHashMap<>();

    InteractionDragsSuplements save(InteractionDragsSuplements interaction) {
        requireNonNull(interaction);
        map.put(interaction.toString(), interaction);
        return interaction;
    }

    InteractionDragsSuplements find(String name) {
        return map.get(name);
    }

    void delete(String name) {
        map.remove(name);
    }
    
}
