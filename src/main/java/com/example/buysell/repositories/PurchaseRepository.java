package com.example.buysell.repositories;

import com.example.buysell.models.Purchase;
import com.example.buysell.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query(value = """
                SELECT SUM(total_cost)
                FROM purchases
                WHERE DATE(purchase_date_time) = :date
            """, nativeQuery = true)
    Optional<Long> findTotalCostPerDay(@Param("date") LocalDate date);
}
