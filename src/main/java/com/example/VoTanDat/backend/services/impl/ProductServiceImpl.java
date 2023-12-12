package com.example.VoTanDat.backend.services.impl;

import com.example.VoTanDat.backend.models.Category;
import com.example.VoTanDat.backend.models.Product;
import com.example.VoTanDat.backend.repositories.ProductRepository;
import com.example.VoTanDat.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired private ProductRepository productRepo;

    @Override
    public Collection<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Collection<Product> getProductByCategory(long categoryId) {
        return productRepo.getProductByCategoryId(categoryId);
    }

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepo.findById(id) != null ? Optional.of(productRepo.findById(id).get()) : Optional.empty();
    }

}
