package com.example.shop_web.controller;

import com.example.shop_web.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oder")
public class BillController {

    @GetMapping
    public String showOder(){
        return "user/layoutOder";
    }
}
