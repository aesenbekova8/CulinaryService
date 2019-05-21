package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
