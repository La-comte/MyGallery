package com.example.buysell.services;

import com.example.buysell.models.Product;
import com.example.buysell.models.Purchase;
import com.example.buysell.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Transactional
    public ResponseEntity<String> savePurchase(List<Product> products, Long totalCost){
        Purchase purchase = new Purchase();
        purchase.setProducts(products);
        purchase.setTotalCost(totalCost);

        purchaseRepository.save(purchase);
        return new ResponseEntity<>("Заказ оформлен", HttpStatus.CREATED);
    }
}
