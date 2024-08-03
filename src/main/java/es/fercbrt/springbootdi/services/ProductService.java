package es.fercbrt.springbootdi.services;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
                    Product product = p.clone();
                    product.setPrice(product.getPrice() * 2);
                    return product;
                }
        ).toList();
    }

    public Product findById (Long id) {
        return repository.findById(id);
    }
}
