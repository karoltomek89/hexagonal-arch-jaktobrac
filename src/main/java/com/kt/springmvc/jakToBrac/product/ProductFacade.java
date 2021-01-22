package com.kt.springmvc.jakToBrac.product;

import com.kt.springmvc.jakToBrac.product.dto.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductFacade {

    ProductFacade(InMemoryProductRepository inMemoryProductRepository) {
        this.inMemoryProductRepository = inMemoryProductRepository;
    }

    private InMemoryProductRepository inMemoryProductRepository;

    public void addProduct(Product product) {

        inMemoryProductRepository.save(product);

    }

    public void removeProduct(Product product) {
        inMemoryProductRepository.delete(product.getProductName());
    }

    public List<Product> getProductList() {

        return inMemoryProductRepository.findAll();
    }

    public Product getProductDetalis(String name) {

        return inMemoryProductRepository.findOneOrThrow(name);
    }
}
