package com.example.VoTanDat;

import com.example.VoTanDat.backend.models.Category;
import com.example.VoTanDat.backend.models.Product;
import com.example.VoTanDat.backend.repositories.CategoryRepository;
import com.example.VoTanDat.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
@EntityScan(basePackages = "com.example.VoTanDat.backend.models")
public class VoTanDatApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoTanDatApplication.class, args);
    }

    @Autowired private CategoryRepository categoryRepository;
    @Autowired private ProductRepository productRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            productRepository.delete(new Product(1002));
//            Random rnd = new Random();
//            for (int i = 1; i <= 5; i++) {
//                Category category = new Category(i, "Category " + i);
//                categoryRepository.save(category);
//            }
//
//            for (int i = 0; i < 1000; i++) {
//                Product product = new Product(i, "Product " + i, rnd.nextDouble() * 100, new Category(rnd.nextInt(5) + 1));
//                productRepository.save(product);
//            }

        };
    }
}
