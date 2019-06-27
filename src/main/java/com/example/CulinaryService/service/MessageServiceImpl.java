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
    public Message sendMessage(Message message, Long toUserId) {
        User toUser = userRepository.findById(toUserId).get();
        User fromUser = userRepository.findById(helper.getCurrentUser().getId()).get();
        List<Message> messages = messageRepository.findAll();
        for (Message m : messages) {
            if (m.getFromUser().equals(fromUser) && m.getFromUser().equals(fromUser)) {
                List<Chat> chats = toUser.getChats();
                message.setFromUser(fromUser);
                message.setToUser(toUser);
                messageRepository.save(message);
                fromUser.setChats(chats);
                userRepository.save(fromUser);
                return message;
            } else {
                List<Chat> chats = new ArrayList<>();
                message.setFromUser(fromUser);
                message.setToUser(toUser);
                messageRepository.save(message);
                fromUser.setChats(chats);
                toUser.setChats(chats);
                userRepository.save(fromUser);
                userRepository.save(toUser);
                return message;
            }
        }
        return message;
    }
}