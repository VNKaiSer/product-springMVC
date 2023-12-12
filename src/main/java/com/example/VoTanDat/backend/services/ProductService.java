package com.example.VoTanDat.backend.services;

import com.example.VoTanDat.backend.models.Category;
import com.example.VoTanDat.backend.models.Product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Collection<Product> getAllProduct();
    Collection<Product> getProductByCategory(long categoryId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
    Optional<Product> getProductById(long id);
}
