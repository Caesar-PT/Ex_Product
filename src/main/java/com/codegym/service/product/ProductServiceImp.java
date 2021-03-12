package com.codegym.service.product;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delProduct(Long id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findAllByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    public List<Product> findTop5ByOrderByPriceDesc() {
        return productRepository.findTop5ByOrderByPriceDesc();
    }

    @Override
    public List<Product> findTop5ByOrderByDateDesc() {
        return productRepository.findTop5ByOrderByDateDesc();
    }

    @Override
    public double getSumPrice() {
        return productRepository.getSumPrice();
    }
}
