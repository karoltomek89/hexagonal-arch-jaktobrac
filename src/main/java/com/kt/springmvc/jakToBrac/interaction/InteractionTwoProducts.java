package com.kt.springmvc.jakToBrac.interaction;

import com.kt.springmvc.jakToBrac.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InteractionTwoProducts {

    private Product productA;
    private Product productB;
    private InteractionType interactionType;
    private int minDelayInHours;


}
