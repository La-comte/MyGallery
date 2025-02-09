package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.repositories.PurchaseRepository;
import com.example.buysell.services.ProductService;
import com.example.buysell.services.PurchaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final ProductService productService;
    private final PurchaseService purchaseService;

    @GetMapping()
    public String getCartPage(@CookieValue(value = "cart", defaultValue = "[]") String cartCookie, Model model)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String decodedCookie = URLDecoder.decode(cartCookie, StandardCharsets.UTF_8);
        List<Long> cart = objectMapper.readValue(decodedCookie, new TypeReference<List<Long>>() {
        });

        List<Product> cartDto = new ArrayList<>();
        long totalCost = 0;
        for (int i = 0; i < cart.size(); i++) {
            Product product = productService.getProductById(cart.get(i));
            cartDto.add(product);
            totalCost += product.getPrice();
        }
        model.addAttribute("cart", cartDto);
        model.addAttribute("totalCost", totalCost);
        return "cart";
    }

    @GetMapping("/add/{productId}")
    public String addProductToCart(@PathVariable Long productId,
                                   @CookieValue(value = "cart", defaultValue = "[]") String cartCookie,
                                   HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String decodedCookie = URLDecoder.decode(cartCookie, StandardCharsets.UTF_8);
        List<Long> cart = objectMapper.readValue(decodedCookie, new TypeReference<List<Long>>() {
        });

        cart.add(productId);

        String updatedCart = objectMapper.writeValueAsString(cart);
        String encodedCart = URLEncoder.encode(updatedCart, StandardCharsets.UTF_8);
        Cookie cookie = new Cookie("cart", encodedCart);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(24 * 60 * 60); // Cookie действует 1 день
        response.addCookie(cookie);

        return "redirect:/";
    }

    @GetMapping("/remove/{productId}")
    public String removeProductFromCart(@PathVariable Long productId,
                                   @CookieValue(value = "cart", defaultValue = "[]") String cartCookie,
                                   HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String decodedCookie = URLDecoder.decode(cartCookie, StandardCharsets.UTF_8);
        List<Long> cart = objectMapper.readValue(decodedCookie, new TypeReference<List<Long>>() {
        });

        cart.remove(productId);

        String updatedCart = objectMapper.writeValueAsString(cart);
        String encodedCart = URLEncoder.encode(updatedCart, StandardCharsets.UTF_8);
        Cookie cookie = new Cookie("cart", encodedCart);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(24 * 60 * 60); // Cookie действует 1 день
        response.addCookie(cookie);

        return "redirect:/cart";
    }

    @PostMapping("/purchase")
    public String makePurchase(@CookieValue(value = "cart", defaultValue = "[]") String cartCookie,
                               HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String decodedCookie = URLDecoder.decode(cartCookie, StandardCharsets.UTF_8);
        List<Long> cart = objectMapper.readValue(decodedCookie, new TypeReference<List<Long>>() {
        });

        List<Product> products = new ArrayList<>();
        long totalCost = 0;
        for (int i = 0; i < cart.size(); i++) {
            Product product = productService.getProductById(cart.get(i));
            products.add(product);
            totalCost += product.getPrice();
        }

        if (purchaseService.savePurchase(products, totalCost).getStatusCode().is2xxSuccessful()) {
            Cookie cookie = new Cookie("cart", "[]");
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/";
    }
}
