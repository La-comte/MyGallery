package com.example.buysell.repositories;

import com.example.buysell.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);

    @Query(value = """
                SELECT p.*
                FROM products p
                JOIN purchase_product pp ON p.id = pp.product_id
                GROUP BY p.id, p.title
                ORDER BY COUNT(pp.product_id) DESC
                LIMIT 1
            """, nativeQuery = true)
    Optional<Product> findMostFrequentProduct();

    @Query(value = """
                SELECT p.*
                FROM products p
                JOIN purchase_product pp ON p.id = pp.product_id
                GROUP BY p.id, p.title
                ORDER BY COUNT(pp.product_id) ASC
                LIMIT 1
            """, nativeQuery = true)
    Optional<Product> findLeastFrequentProduct();
}
