package com.example.shop_web.service.product;

import com.example.shop_web.domain.Image;
import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.service.IGeneralService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService extends IGeneralService<Product,Long> {
    List<ProductResDTO> findAllProductResDTO(Boolean deleted);
    ProductResDTO findProductResDTO(Long productId);

    void uploadAndSaveImage(Image image, MultipartFile file);
}
