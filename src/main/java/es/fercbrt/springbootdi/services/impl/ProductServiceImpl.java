package es.fercbrt.springbootdi.services.impl;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;
import es.fercbrt.springbootdi.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
