package com.example.shop_web.service.image;

import com.cloudinary.Cloudinary;
import com.example.shop_web.domain.Image;
import com.example.shop_web.repository.ImageRepository;
import com.example.shop_web.util.UploadUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private final Cloudinary cloudinary;

    private final ImageRepository imageRepository;

    private final UploadUtil uploadUtil;


    @Override
    public List<Image> findAll() {
        return null;
    }

    @Override
    public Optional<Image> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void update(Image image) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
