package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Method to find products by name
    List<Product> findByName(String name);

    // Method to find products within a price range
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    // Custom query to find all products and sort them by price in descending order
    List<Product> findAllByOrderByPriceDesc();
}
