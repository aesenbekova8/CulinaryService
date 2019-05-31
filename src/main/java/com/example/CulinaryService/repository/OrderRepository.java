package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
