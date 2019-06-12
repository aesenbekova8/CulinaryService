package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Chat;
import com.example.CulinaryService.model.Message;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.repository.ChatRepository;
import com.example.CulinaryService.repository.MessageRepository;
import com.example.CulinaryService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Chat getAllByUserId(Long userId) {
        User user = userRepository.findById(userId).get();
        Chat chat = chatRepository.findByUser(user);
        return chat;
    }
}
