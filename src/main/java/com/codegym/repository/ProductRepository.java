package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findAllByCategory(Category category);

    List<Product> findTop5ByOrderByPriceDesc();

    List<Product> findTop5ByOrderByDateDesc();

    @Query(value = "select sum(price) from Product", nativeQuery = false)
    double getSumPrice();

}
