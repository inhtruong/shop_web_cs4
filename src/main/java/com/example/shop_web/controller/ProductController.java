package com.example.shop_web.controller;

import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping()
    public String showProduct(Model model, Authentication authentication) {
        if(authentication == null){
            return "user/login";
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        List<ProductResDTO> products = productService.findAllProductResDTO(false);
        model.addAttribute("products", products);
        // Kiểm tra vai trò và thêm vào model nếu cần
        if (userDetails.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {
            model.addAttribute("isAdmin", true);
        } else {
            model.addAttribute("isUser",true);
        }
        return "admin/createProduct";
    }
    @GetMapping("/ban")
    public String showBanProduct(Model model) {
        List<ProductResDTO> products = productService.findAllProductResDTO(true);
        model.addAttribute("products", products);
        return "admin/banListProduct";
    }
}
