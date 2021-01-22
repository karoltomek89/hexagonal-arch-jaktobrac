package com.kt.springmvc.jakToBrac.product;

import com.kt.springmvc.jakToBrac.product.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryProductRepository {

    private ConcurrentHashMap<String, Product> map = new ConcurrentHashMap<>();

    Product save(Product product) {
        requireNonNull(product);
        map.put(product.getProductName(), product);
        return product;
    }

    Product findOneOrThrow(String name) {
        Product product = map.get(name);
        if (product == null) {
            throw new ProductNotFoundException(name);
        }
        return product;
    }

    void delete(String name) {
        map.remove(name);
    }

    List<Product> findAll(){
        return new ArrayList<>(map.values());
    }

    class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String name) {
            super("No product of name \"" + name + "\" found", null, false, false);
        }
    }
}
