package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
