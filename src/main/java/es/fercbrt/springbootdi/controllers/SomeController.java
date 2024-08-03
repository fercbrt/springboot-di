package es.fercbrt.springbootdi.controllers;

import es.fercbrt.springbootdi.models.Product;
import es.fercbrt.springbootdi.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class SomeController {

    private final ProductService productService = new ProductService();

    @GetMapping()
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return productService.findById(id);
    }
}
