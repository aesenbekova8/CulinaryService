package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Mark;
import com.example.CulinaryService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    User findByUser(Long userId);
}
