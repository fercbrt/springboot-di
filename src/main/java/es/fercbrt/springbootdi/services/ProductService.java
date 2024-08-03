package es.fercbrt.springbootdi.services;

import es.fercbrt.springbootdi.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
