package es.fercbrt.springbootdi.services.impl;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;
import es.fercbrt.springbootdi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

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
