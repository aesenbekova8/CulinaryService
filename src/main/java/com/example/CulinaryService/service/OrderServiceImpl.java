package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Order;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.repository.CookRepository;
import com.example.CulinaryService.repository.OrderRepository;
import com.example.CulinaryService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CookRepository cookRepository;

    @Override
    public List<Order> getAllOrders(Long userId) {
        User user = userRepository.findById(userId).get();
        List<Order> orders = user.getOrders();
        return orders;
    }

    @Override
    public Order madeOrder(Order order, Long userId, Long cookId) {
        User user = userRepository.findById(userId).get();
        Cook cook = cookRepository.findById(cookId).get();
        List<Order> userOrders = user.getOrders();
        order.setCook(cook);
        order.setUser(user);
        orderRepository.save(order);
        userOrders.add(order);
        user.setOrders(userOrders);
        userRepository.save(user);
        return order;
    }
}
