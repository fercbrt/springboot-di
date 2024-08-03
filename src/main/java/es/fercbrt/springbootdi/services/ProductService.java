package es.fercbrt.springbootdi.services;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream().peek(product -> product.setPrice((product.getPrice()*2))).toList();
    }

    public Product findById (Long id) {
        return repository.findById(id);
    }
}
