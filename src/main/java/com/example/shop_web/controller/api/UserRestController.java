package com.example.shop_web.controller.api;

import com.example.shop_web.domain.User;
import com.example.shop_web.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/{idUser}")
    public ResponseEntity<?> getUserById(@PathVariable Long idUser){
            User user = userService.findById(idUser).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
