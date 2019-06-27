package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Message;
import com.example.CulinaryService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findByFromUser(User fromUser);
    Message findByToUser(User toUser);
}
