package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.repositories.ProductRepository;
import com.example.buysell.repositories.PurchaseRepository;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping
    public String adminPage(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("ordersNum", purchaseRepository.findAll().size());
        model.addAttribute("totalCostPerDay", purchaseRepository.findTotalCostPerDay(LocalDate.now()).orElse(null));
        Optional<Product> a = productRepository.findMostFrequentProduct();
        model.addAttribute("theMostPopularProduct", productRepository.findMostFrequentProduct().orElse(null));
        model.addAttribute("theMostUnpopularProduct", productRepository.findLeastFrequentProduct().orElse(null));
        model.addAttribute("products", productService.listProducts(title));
        return "admin";
    }

}
