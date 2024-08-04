package es.fercbrt.springbootdi.config;

import es.fercbrt.springbootdi.repositories.ProductRepository;
import es.fercbrt.springbootdi.repositories.impl.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    ProductRepository productRepository() {
        return new ProductRepositoryJson();
    }
}
