package es.fercbrt.springbootdi.services.impl;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;
import es.fercbrt.springbootdi.repositories.impl.ProductRepositoryImpl;
import es.fercbrt.springbootdi.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository = new ProductRepositoryImpl();

    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p -> {
                    Product product = p.clone();
                    product.setPrice(product.getPrice() * 2);
                    return product;
                }
        ).toList();
    }

    public Product findById (Long id) {
        return productRepository.findById(id);
    }
}
