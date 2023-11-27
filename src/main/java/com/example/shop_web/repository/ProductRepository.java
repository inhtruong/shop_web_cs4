package com.example.shop_web.repository;

import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.ProductResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {
//this.quantity = quantity;
//        this.warrantyPeriod = warrantyPeriod;
//        this.ram = ram;
//        this.size = size;
//        this.color = color;
//        this.camera = camera;
//        this.operatingSystem = operatingSystem;
//        this.pin = pin;
//        this.price = price;
    @Query("SELECT NEW com.example.shop_web.domain.dto.ProductResDTO ( " +
            "pro.id, " +
            "pro.productName, " +
            "pro.branch, " +
            "pro.quantity ," +
            "pro.warrantyPeriod ," +
            "pro.ram ," +
            "pro.size ," +
            "pro.color ," +
            "pro.camera ," +
            "pro.operatingSystem ," +
            "pro.pin ," +
            "pro.price, " +
            "pro.image " +
            ") " +
            "FROM Product AS pro WHERE pro.deleted = :deleted"
    )
    List<ProductResDTO> findAllProductResDTO(@Param("deleted") Boolean deleted );
   ;
    @Query("SELECT NEW com.example.shop_web.domain.dto.ProductResDTO ( " +
            "pro.id, " +
            "pro.productName, " +
            "pro.branch, " +
            "pro.quantity ," +
            "pro.warrantyPeriod ," +
            "pro.ram ," +
            "pro.size ," +
            "pro.color ," +
            "pro.camera ," +
            "pro.operatingSystem ," +
            "pro.pin ," +
            "pro.price, " +
            "pro.image " +
            ") " +
            "FROM Product AS pro WHERE pro.id = :productId"
    )
    ProductResDTO findProductResDTO(@Param("productId") Long productId );
    ;



}
