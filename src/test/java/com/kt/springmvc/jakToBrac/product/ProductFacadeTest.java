package com.kt.springmvc.jakToBrac.product;

import com.kt.springmvc.jakToBrac.product.dto.ActiveSubstanceOfSuplement;
import com.kt.springmvc.jakToBrac.product.dto.Component;
import com.kt.springmvc.jakToBrac.product.dto.Product;
import com.kt.springmvc.jakToBrac.product.dto.ProductType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    void shouldFindProductWhenProductAdded() {

        //given
        Product vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);
        Product calc = createProduct("Calcium", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.CALCIUM);
        //when
        productFacade.addProduct(vitD3);
        //then
        assertEquals(productFacade.getProductDetalis("Vigaflex Forte"), vitD3);
    }

    @Test
    void shouldThrowExceptionwhenProductNotFound() {
        //when //then
        assertThrows(InMemoryProductRepository.ProductNotFoundException.class,
                () -> productFacade.getProductDetalis("Vigaflex Forte"));
    }


    @Test
    void shouldReturnProductListWhenProductsAdded() {
        //given
        Product vitD3 = createProduct("Vigaflex Forte", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.VITAMIN_D3);
        Product calc = createProduct("Calcium", ProductType.SUPLEMENT, ActiveSubstanceOfSuplement.CALCIUM);
        List<Product> productList = List.of(vitD3,calc);

        //when
        productFacade.addProduct(vitD3);
        productFacade.addProduct(calc);

        //then
        assertTrue(productFacade.getProductList().containsAll(productList));
    }

    private Product createProduct(String name, ProductType type, Component component) {
        return new Product.ProductBuilder().withName(name).withType(type).withMainComponent(component).build();
    }
}