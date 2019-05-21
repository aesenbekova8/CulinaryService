package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Cook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookRepository extends JpaRepository<Cook, Long> {
}
