package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Chat;
import com.example.CulinaryService.model.Message;
import com.example.CulinaryService.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/getAll")
    public List<Chat> getByUserId(){
        return chatService.getAllByUserId();
    }

    @PostMapping("/{toUserId}/send")
    public List<Message> start(@RequestBody Message message,
                                      @PathVariable Long toUserId){
        return chatService.startChat(message, toUserId);
    }
}
