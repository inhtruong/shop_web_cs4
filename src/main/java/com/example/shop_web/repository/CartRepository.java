package com.example.shop_web.repository;


import com.example.shop_web.domain.Cart;
import com.example.shop_web.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long user_id);
}
