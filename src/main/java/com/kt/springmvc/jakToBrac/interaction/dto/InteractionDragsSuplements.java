package com.kt.springmvc.jakToBrac.interaction.dto;

import com.kt.springmvc.jakToBrac.product.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InteractionDragsSuplements {

    private Product productA;
    private Product productB;
    private InteractionType interactionType;



}
