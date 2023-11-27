package com.example.shop_web.controller;
import com.example.shop_web.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public String showCart(){
            return "user/layoutCarts";
    }
}
