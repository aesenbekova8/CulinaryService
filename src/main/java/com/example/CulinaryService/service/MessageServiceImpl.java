package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Message;
import com.example.CulinaryService.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements CrudService<Message> {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message add(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message getById(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public Message update(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
