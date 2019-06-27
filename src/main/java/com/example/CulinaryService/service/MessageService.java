package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Chat;
import com.example.CulinaryService.model.Message;

public interface MessageService {
    Message sendMessage(Message message, Long toUserId);
}
