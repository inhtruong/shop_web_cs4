package com.example.shop_web.service.product;

import com.example.shop_web.domain.Image;
import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.exception.DataInputException;
import com.example.shop_web.repository.ImageRepository;
import com.example.shop_web.repository.ProductRepository;
import javax.transaction.Transactional;

import com.example.shop_web.service.uploadImage.UploadService;
import com.example.shop_web.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImple implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UploadUtil uploadUtils;

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);

    }


    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<ProductResDTO> findAllProductResDTO(Boolean deleted) {
        return productRepository.findAllProductResDTO(deleted);
    }

    @Override
    public ProductResDTO findProductResDTO(Long productId) {
        return productRepository.findProductResDTO(productId);
    }

    @Override
    public void uploadAndSaveImage(Image image, MultipartFile file) {
        try {
                Map uploadResult = uploadService.uploadImage(file, uploadUtils.buildImageUploadParams(image));
            String fileUrl = (String) uploadResult.get("secure_url");
            String fileFormat = (String) uploadResult.get("format");

            image.setFileName(image.getId() + "." + fileFormat);
            image.setFileUrl(fileUrl);
            image.setFileFolder(UploadUtil.IMAGE_UPLOAD_FOLDER);
            image.setCloudId(image.getFileFolder() + "/" + image.getId());
            imageRepository.save(image);

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload hình ảnh thất bại");
        }
    }
}
