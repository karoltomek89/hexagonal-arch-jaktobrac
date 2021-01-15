package com.kt.springmvc.jakToBrac.recomendation;

import com.kt.springmvc.jakToBrac.recomendation.dto.Recomendation;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryRecomendationRepository {

    private ConcurrentHashMap<String, Recomendation> map = new ConcurrentHashMap<>();

    Recomendation save(Recomendation recomendation) {
        requireNonNull(recomendation);
        map.put(recomendation.toString(), recomendation);
        return recomendation;
    }

    Recomendation findOneOrThrow(String name) {
        Recomendation recomendation = map.get(name);
        if (recomendation == null) {
            throw new InMemoryRecomendationRepository.RecomendationNotFoundException(name);
        }
        return recomendation;
    }

    void delete(String name) {
        map.remove(name);
    }

    class RecomendationNotFoundException extends RuntimeException {
        public RecomendationNotFoundException(String title) {
            super("No recomendation of name \"" + title + "\" found", null, false, false);
        }
    }

}
