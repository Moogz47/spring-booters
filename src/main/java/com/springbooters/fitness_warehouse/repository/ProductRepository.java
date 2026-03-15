package com.springbooters.fitness_warehouse.repository;

import com.springbooters.fitness_warehouse.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByBrandContainingIgnoreCaseAndCategoryContainingIgnoreCase(
            String brand,
            String category,
            Pageable pageable
    );
}