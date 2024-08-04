package es.fercbrt.springbootdi.repositories.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.repositories.ProductRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository("productJsonList")
public class ProductRepositoryJson implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/products.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            data = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data
                .stream().filter(
                    product -> product.getId().equals(id)
                )
                .findFirst()
                .orElse(null);
    }
}
