package es.fercbrt.springbootdi.repositories;

import es.fercbrt.springbootdi.models.Product;

import java.util.List;

public class ProductRepository {
    private List<Product> data;

    public ProductRepository() {
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
}
