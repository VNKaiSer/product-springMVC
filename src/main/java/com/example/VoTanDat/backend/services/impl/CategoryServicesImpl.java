package com.example.VoTanDat.backend.services.impl;

import com.example.VoTanDat.backend.models.Category;
import com.example.VoTanDat.backend.repositories.CategoryRepository;
import com.example.VoTanDat.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class CategoryServicesImpl implements CategoryService {
    @Autowired private CategoryRepository categoryRepository;


    @Override
    public Collection<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
