package com.codegym.service.category;

import com.codegym.model.Category;
import com.codegym.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void addProduct(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category editProduct(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delProduct(Long id) {
        categoryRepository.delete(id);
    }
}
