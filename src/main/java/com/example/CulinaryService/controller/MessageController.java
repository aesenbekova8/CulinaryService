package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Message;
import com.example.CulinaryService.repository.MessageRepository;
import com.example.CulinaryService.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/send/{toUserId}")
    public ResponseEntity<Message> send(@RequestBody Message m,
                                        @PathVariable Long toUserId){
        try {
            Message message = messageService.sendMessage(m, toUserId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
