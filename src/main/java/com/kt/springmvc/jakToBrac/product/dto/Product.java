package com.kt.springmvc.jakToBrac.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {

    private String productName;
    private ProductType productType;
    private Component component;
    private List<Component> otherComponentList;

   private Product() {    }

   public static class ProductBuilder {
        private Product product;

        public ProductBuilder() {
            this.product = new Product();
        }

        public ProductBuilder withName(String prductName) {
            product.setProductName(prductName);
            return this;
        }

        public ProductBuilder withType(ProductType prductType) {
            product.setProductType(prductType);
            return this;
        }

        public ProductBuilder withMainComponent(Component component) {
            product.setComponent(component);
            return this;
        }

        public ProductBuilder withOtherComponents(List<Component> otherComponentList) {
            product.setOtherComponentList(otherComponentList);
            return this;
        }

        public Product build() {
            return product;
        }
    }
}
