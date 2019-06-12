package com.example.CulinaryService.service;

import com.example.CulinaryService.helpers.Helper;
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
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private Helper helper;

    @Override
    public Message sendMessage(Message message, Long fromUserId, Long toUserId) {
        messageRepository.save(message);
        List<Message> messages = new ArrayList<>();
        User toUser = userRepository.findById(toUserId).get();
        User fromUser = userRepository.findById(fromUserId).get();
        message.setFromUserId(fromUser);
        message.setToUserId(toUser);
        messages.add(message);
        messageRepository.save(message);
        Chat chat = chatRepository.findByUser(fromUser);
        if (chat == null){
            Chat newChat = new Chat();
            newChat.setUser(fromUser);
            messageRepository.save(message);
            newChat.setMessages(messages);
            chatRepository.save(newChat);
        }
        else {
            chat.setUser(fromUser);
            messageRepository.save(message);
            chat.setMessages(messages);
            chatRepository.save(chat);
        }
        return message;
    }
}
