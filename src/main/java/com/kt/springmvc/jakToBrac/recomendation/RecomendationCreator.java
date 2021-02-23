package com.kt.springmvc.jakToBrac.recomendation;

import com.kt.springmvc.jakToBrac.interaction.dto.FoodInteraction;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionDragsSuplements;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionFood;
import com.kt.springmvc.jakToBrac.interaction.dto.InteractionType;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import com.kt.springmvc.jakToBrac.recomendation.dto.Recomendation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class RecomendationCreator {

    static Map<String,Map<Product, Set<Product>>> checkTogetherOrNot(List<Product> productList,
                                                    List<InteractionDragsSuplements> interactionDragsSuplementsList) {
        Map<Product, Set<Product>> productsEatTogether = new HashMap<>();
        Map<Product, Set<Product>> productsEatNotTogether = new HashMap<>();
        Map<String,Map<Product, Set<Product>>> mapTogetherOrNot = new HashMap<>();
        mapTogetherOrNot.put("productsEatTogether", productsEatTogether);
        mapTogetherOrNot.put("productsEatNotTogether", productsEatNotTogether);

        for (Product p : productList) {
            Set<Product> productTogetherSet = new HashSet<>();
            Set<Product> productNotTogetherSet = new HashSet<>();
            productsEatTogether.put(p, productTogetherSet);
            productsEatNotTogether.put(p, productNotTogetherSet);

            for (InteractionDragsSuplements inter : interactionDragsSuplementsList) {
                if (inter.getProductA().getProductName().equals(p.getProductName())
                        && (InteractionType.POSITIVE.equals(inter.getInteractionType())
                        || InteractionType.NO_INFORMATION.equals(inter.getInteractionType())
                )
                ) {

                    productsEatTogether.get(p).add(inter.getProductB());

                }else if(inter.getProductA().getProductName().equals(p.getProductName())
                                && InteractionType.NEGATIVE.equals(inter.getInteractionType())) {
                    productsEatNotTogether.get(p).add(inter.getProductB());

                }
            }
        }

        for ( Map.Entry<Product, Set<Product>> entry : productsEatTogether.entrySet()) {
            for (Product product : entry.getValue()) {
                productsEatTogether.get(product).add(entry.getKey());
            }
        }

        for ( Map.Entry<Product, Set<Product>> entry : productsEatNotTogether.entrySet()) {
            for (Product product : entry.getValue()) {
                productsEatNotTogether.get(product).add(entry.getKey());
            }
        }


        return mapTogetherOrNot;
    }

    static Map<Product, InteractionFood> checkFilterFoodInteractions(List<InteractionFood> interactionFoodList) {

        return interactionFoodList.stream()
                .filter( p -> FoodInteraction.NO_INFORMATION !=p.getFoodInteraction())
                .collect(Collectors.toMap(InteractionFood::getProduct, interactionFood -> interactionFood));
    }

    static Recomendation createRecomendation(List<Product> productList,
                                             List<InteractionDragsSuplements> interactionDragsSuplementsList,
                                             List<InteractionFood> interactionFoodList) {

        Map<String,Map<Product, Set<Product>>> mapTogetherOrNot = checkTogetherOrNot(productList, interactionDragsSuplementsList);
        Map<Product, Set<Product>> productsEatTogether = mapTogetherOrNot.get("productsEatTogether");
        Map<Product, Set<Product>> productsEatNotTogether = mapTogetherOrNot.get("productsEatNotTogether");
        Map<Product, InteractionFood> productsFoodInformation = checkFilterFoodInteractions(interactionFoodList);

        return Recomendation.create(productsEatTogether, productsEatNotTogether, productsFoodInformation);

    }

}
