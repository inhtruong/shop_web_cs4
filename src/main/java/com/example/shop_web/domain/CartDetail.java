package com.example.shop_web.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Table(name = "cart_details")
@Entity
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  int quantity;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private  Cart cart;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private  Product product;
    @Column(name = "checked", columnDefinition = "TINYINT(1)")
    private Boolean checked;
}
