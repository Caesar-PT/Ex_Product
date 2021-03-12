package com.codegym.service.product;

import com.codegym.model.Category;
import com.codegym.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product findById(long id);

    void addProduct(Product product);

    Product editProduct(Product product);

    void delProduct(Long id);

    List<Product> findAllByCategory(Category category);

    List<Product> findTop5ByOrderByPriceDesc();

    List<Product> findTop5ByOrderByDateDesc();

    @Query(value = "select sum(price) form product", nativeQuery = true)
    double getSumPrice();


}
