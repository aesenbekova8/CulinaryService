package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Chat;
import com.example.CulinaryService.model.Message;

import java.util.List;

public interface ChatService {
    List<Chat> getAllByUserId();
    List<Message> startChat( Message message, Long toUserId);
}
