package es.fercbrt.springbootdi.repositories.impl;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class ProductRepositoryJPA implements ProductRepository {
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(
                new Product(1L, "Product from JPA", 100L)
        );
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Product from JPA", 100L);
    }
}
