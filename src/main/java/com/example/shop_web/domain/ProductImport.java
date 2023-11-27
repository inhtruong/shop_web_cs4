package com.example.shop_web.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "product_imports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(name = "import_date")
    private Date importDate;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

}
