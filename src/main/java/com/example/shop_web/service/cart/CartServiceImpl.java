package com.example.shop_web.service.cart;

import com.example.shop_web.domain.Cart;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements ICartService {
    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Cart save(Cart cart) {
        return null;
    }


    @Override
    public void update(Cart cart) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
