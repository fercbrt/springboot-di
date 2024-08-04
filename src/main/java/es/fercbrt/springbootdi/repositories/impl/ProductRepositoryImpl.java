package es.fercbrt.springbootdi.repositories.impl;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

//@RequestScope
//@SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> data;

    public ProductRepositoryImpl() {
        data = List.of(
            new Product(1L, "Product 1", 100L),
            new Product(2L, "Product 2", 200L),
            new Product(3L, "Product 3", 300L),
            new Product(4L, "Product 4", 400L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}
