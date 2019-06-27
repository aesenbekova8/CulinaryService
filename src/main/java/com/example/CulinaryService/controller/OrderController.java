package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Order;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.repository.OrderRepository;
import com.example.CulinaryService.service.CrudService;
import com.example.CulinaryService.service.OrderService;
import com.example.CulinaryService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/toOrder/{cookId}")
    public ResponseEntity<Order> toOrder(@RequestBody Order o, @PathVariable Long cookId) {
        try {
            Order order = orderService.madeOrder(o, cookId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
