package com.example.shop_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestTemplateController {
    @GetMapping
    public String testTemplate(){
        return "/user/productDetail";
    }
}
