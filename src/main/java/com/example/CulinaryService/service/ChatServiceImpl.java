package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Chat;
import com.example.CulinaryService.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements CrudService<Chat>{
    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat add(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> getAll() {
        return chatRepository.findAll();
    }

    @Override
    public Chat getById(Long id) {
        return chatRepository.findById(id).get();
    }

    @Override
    public Chat update(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public void delete(Long id) {
        chatRepository.deleteById(id);
    }
}
