package com.kt.springmvc.jakToBrac.interaction.dto;

import com.kt.springmvc.jakToBrac.product.dto.Product;
import lombok.Data;
import lombok.NonNull;

@Data
public class InteractionDragsSuplements {

    @NonNull
    private Product productA;
    @NonNull
    private Product productB;
    @NonNull
    private InteractionType interactionType;

}
