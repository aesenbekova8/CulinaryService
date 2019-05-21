package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
