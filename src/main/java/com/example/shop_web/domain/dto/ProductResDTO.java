package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductResDTO implements Validator {
    private Long id;
    private String productName;
    private BranchResDTO branch;
    private int quantity;
    private String warrantyPeriod;
    private String ram;
    private String size;
    private String color;
    private String camera;
    private String operatingSystem;
    private String pin;
    private BigDecimal price;
    private Image image;

    //private ImageReqDTO imageReqDTO;
    public ProductResDTO(Long id, String productName, Branch branch, int quantity, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.branch = branch.toBranchReqDTO();
        this.quantity = quantity;
        this.price = price;
    }

    public ProductResDTO(Long id, String productName, Branch branch, int quantity, String warrantyPeriod, String ram, String size, String color, String camera, String operatingSystem, String pin, BigDecimal price, Image image) {
        this.id = id;
        this.productName = productName;
        this.branch = branch.toBranchReqDTO();
        this.quantity = quantity;
        this.warrantyPeriod = warrantyPeriod;
        this.ram = ram;
        this.size = size;
        this.color = color;
        this.camera = camera;
        this.operatingSystem = operatingSystem;
        this.pin = pin;
        this.price = price;
        this.image = image;
    }

    public ProductResDTO(Long id, String productName, Branch branch, int quantity, String warrantyPeriod, String ram, String size, String color, String camera, String operatingSystem, String pin, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.branch = branch.toBranchReqDTO();
        this.quantity = quantity;
        this.warrantyPeriod = warrantyPeriod;
        this.ram = ram;
        this.size = size;
        this.color = color;
        this.camera = camera;
        this.operatingSystem = operatingSystem;
        this.pin = pin;
        this.price = price;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
