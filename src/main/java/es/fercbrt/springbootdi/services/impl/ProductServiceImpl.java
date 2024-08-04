package es.fercbrt.springbootdi.services.impl;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;
import es.fercbrt.springbootdi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Environment environment;
    private ProductRepository productRepository;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p -> {
                    Product product = p.clone();
                    product.setPrice(product.getPrice() * environment.getProperty("config.price", Long.class));
                    return product;
//                    p.setPrice(p.getPrice() * 2);
//                    return p;
                }
        ).toList();
    }

    public Product findById (Long id) {
        return productRepository.findById(id);
    }
}
