package com.codegym.service.category;

import com.codegym.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category findById(long id);

    void addProduct(Category category);

    Category editProduct(Category category);

    void delProduct(Long id);
}
