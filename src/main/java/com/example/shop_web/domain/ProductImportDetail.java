package com.example.shop_web.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_import_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "product_import_id", referencedColumnName = "id", nullable = false)
    private ProductImport productImport;
}
