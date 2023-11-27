package com.example.shop_web.controller;


import com.example.shop_web.domain.Product;
import com.example.shop_web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/productDetail")
public class ProductDetailController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{idProduct}")
    public String showDetail(@PathVariable Long idProduct, Model model){
        Optional<Product> product = productRepository.findById(idProduct);
        model.addAttribute("product", product.get());
        return "user/productDetail";
    }
}
