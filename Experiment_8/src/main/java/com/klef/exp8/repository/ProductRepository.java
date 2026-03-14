package com.klef.exp8.repository;

import com.klef.exp8.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Derived Query Methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL Query - Sort by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortByPrice();

    // JPQL Query - Products above given price
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findExpensiveProducts(double price);

    // JPQL Query - Products by category
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getProductsByCategory(String category);
}