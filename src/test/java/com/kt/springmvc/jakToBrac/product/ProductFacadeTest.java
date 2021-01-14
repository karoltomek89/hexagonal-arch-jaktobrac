package com.kt.springmvc.jakToBrac.product;

import com.kt.springmvc.jakToBrac.product.dto.Component;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import com.kt.springmvc.jakToBrac.product.dto.ProductType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductFacadeTest {

    ProductFacade productFacade;

    @BeforeEach
    void setUp() {
        productFacade = new ProductConfiguration().productFacade();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addProduct() {
    }

    @Test
    void removeProduct() {
    }

    @Test
    void getProductList() {
    }

    private Product createProduct(String name, ProductType type, Component component){
        return new Product.ProductBuilder().withName(name).withType(type).withMainComponent(component).build();
    }
}