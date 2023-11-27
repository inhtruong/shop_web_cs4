package com.example.shop_web.controller.api;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.Image;
import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.ProductBanReqDTO;
import com.example.shop_web.domain.dto.ProductCreReqDTO;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.service.branch.IBranchService;
import com.example.shop_web.service.image.ImageService;
import com.example.shop_web.service.image.ImageServiceImpl;
import com.example.shop_web.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IBranchService branchService;
    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ProductResDTO> products = productService.findAllProductResDTO(false);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/ban")
    public ResponseEntity<?> getAllProductBan() {
        List<ProductResDTO> products = productService.findAllProductResDTO(true);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@Validated ProductCreReqDTO productCreReqDTO, BindingResult bindingResult) throws IOException {
        new ProductCreReqDTO().validate(productCreReqDTO, bindingResult);

        Image image = new Image();
        imageService.save(image);

        Product product = productCreReqDTO.toProduct(image);
        Branch branch = branchService.findByBranchId(productCreReqDTO.getBranchId());
        product.setBranch(branch);
        product.setQuantity(0);
        product.setDeleted(true);
        productService.save(product);

        productService.uploadAndSaveImage(image, productCreReqDTO.getFile());

        ProductResDTO productResDTO = productCreReqDTO.toProductResDTO();
        productResDTO.setBranch(branch.toBranchReqDTO());
        productResDTO.setPrice(product.getPrice());
        productResDTO.setId(product.getId());
        productResDTO.setImage(product.getImage());

        return new ResponseEntity<>(productResDTO, HttpStatus.CREATED);

    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<?> findById(@PathVariable Long idProduct) {
        ProductResDTO productResDTO = productService.findProductResDTO(idProduct);
        return new ResponseEntity<>(productResDTO, HttpStatus.OK);
    }

    @PatchMapping("/{idProduct}")
    public ResponseEntity<?> update(@Validated ProductCreReqDTO productCreReqDTO, @PathVariable Long idProduct, BindingResult bindingResult) throws IOException {
        new ProductCreReqDTO().validate(productCreReqDTO, bindingResult);

        Image image = new Image();
        imageService.save(image);

        Product product = productCreReqDTO.toProduct(image);
        Product oldProduct = productService.findById(idProduct).get();
        Branch branch = branchService.findByBranchId(productCreReqDTO.getBranchId());
        product.setBranch(branch);
        product.setQuantity(oldProduct.getQuantity());
        product.setId(idProduct);
        productService.save(product);

        productService.uploadAndSaveImage(image, productCreReqDTO.getFile());

        ProductResDTO productResDTO = productCreReqDTO.toProductResDTO();
        productResDTO.setBranch(branch.toBranchReqDTO());
        productResDTO.setPrice(product.getPrice());
        productResDTO.setId(product.getId());
        productResDTO.setImage(product.getImage());

        return new ResponseEntity<>(productResDTO, HttpStatus.OK);
    }

    @PatchMapping("/ban/{idProduct}")
    public ResponseEntity<?> ban(@RequestBody ProductBanReqDTO productBanReqDTO, @PathVariable Long idProduct) {
        Product product = productService.findById(idProduct).get();
        product.setDeleted(true);
        productService.save(product);
        return new ResponseEntity<>(productBanReqDTO, HttpStatus.OK);
    }
    @PatchMapping("/unBan/{idProduct}")
    public ResponseEntity<?> unBan(@RequestBody ProductBanReqDTO productBanReqDTO, @PathVariable Long idProduct) {
        Product product = productService.findById(idProduct).get();
        product.setDeleted(false);
        productService.save(product);
        return new ResponseEntity<>(productBanReqDTO, HttpStatus.OK);
    }
}
