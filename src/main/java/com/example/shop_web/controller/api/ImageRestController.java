package com.example.shop_web.controller.api;

import com.example.shop_web.domain.Image;
import com.example.shop_web.service.image.ImageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/image")
@AllArgsConstructor
public class ImageRestController {
//
//    private final ImageServiceImpl imageServiceImpl;
//
//    @PostMapping
//    public Image upload(@RequestParam("avatar") MultipartFile avatar) throws IOException {
//        return imageServiceImpl.saveAvatar(avatar);
//    }

}
