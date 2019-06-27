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
public class ChatServiceImpl implements ChatService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Helper helper;

    @Override
    public List<Message> startChat(Message message, Long toUserId) {
        User fromUser = userRepository.findById(helper.getCurrentUser().getId()).get();
        User toUser = userRepository.findById(toUserId).get();
        List<Chat> allChats = chatRepository.findAll();
        List<Message> messages = null;
        messageRepository.save(message);

        Message fromMessage = messageRepository.findByFromUser(fromUser);
        Message toMessage = messageRepository.findByToUser(toUser);

        if (allChats.size() == 0) {
            Chat chat = new Chat();
            message.setFromUser(fromUser);
            message.setToUser(toUser);
            messageRepository.save(message);
            messages = new ArrayList<>();
            messages.add(message);
            chat.setMessages(messages);
            chat.setUser(fromUser);
            chatRepository.save(chat);
        } else {
            for (Chat c : allChats) {
                if (c.getUser().equals(fromUser) && c.getUser().equals(toUser)) {
                    for (Message m : c.getMessages()) {
                        if (m.equals(fromMessage) && m.equals(toMessage)) {
                            Chat chat = c;
                            message.setFromUser(fromUser);
                            message.setToUser(toUser);
                            messageRepository.save(message);
                            messages = chat.getMessages();
                            messages.add(message);
                            chat.setMessages(messages);
                            chat.setUser(fromUser);
                            chatRepository.save(chat);
                        }
                    }
                }
            }
        }
        return messages;
    }

    @Override
    public List<Chat> getAllByUserId() {
        User user = userRepository.findById(helper.getCurrentUser().getId()).get();
        List<Chat> chats = chatRepository.findByUser(user);
        return chats;
    }
}