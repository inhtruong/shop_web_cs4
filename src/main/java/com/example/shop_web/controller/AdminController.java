package com.example.shop_web.controller;

import com.example.shop_web.domain.dto.ProductResDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/products-productIP")
    public String showProduct() {
        return "admin/adminProductAndPImport";
    }

    @GetMapping("/branchs")
    public String showBranch() {
        return "admin/adminBranch";
    }
    @GetMapping("/orders")
    public String showOrder() {
        return "admin/adminOrder";
    }
    @GetMapping("/orders/orderConfirming")
    public String showOrderConfirming() {
        return "admin/adminOrderConfirming";
    }
    @GetMapping("/orders/orderConfirmed")
    public String showOrderConfirmed() {
        return "admin/adminOrderConfirmed";
    }
    @GetMapping("/orders/orderCanceled")
    public String showOrderCanceled() {
        return "admin/adminOrderCanceled";
    }
}
