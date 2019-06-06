package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Order;
import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    Order madeOrder(Order order, Long userId, Long cookId);
    List<Order> getAllOrders(Long userId);
//    User getByName(String name);
}
