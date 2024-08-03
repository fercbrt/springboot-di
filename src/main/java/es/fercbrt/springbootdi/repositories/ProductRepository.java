package es.fercbrt.springbootdi.repositories;

import es.fercbrt.springbootdi.models.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> findAll();
    public Product findById(Long id);
}
