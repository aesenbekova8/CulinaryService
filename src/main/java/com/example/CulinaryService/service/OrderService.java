package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Order;

import java.util.List;

public interface OrderService {
    Order madeOrder(Order order, Long cookId);
    List<Order> getAllOrders();
}
