package com.example.shop_web.service.order;

import com.example.shop_web.domain.Order;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements IOrderService{
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Order save(Order order) {
        return null;
    }


    @Override
    public void update(Order order) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
