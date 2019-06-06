package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CookService cookService;

    @Autowired
    private CookServiceImpl cookServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<User> userRegistration(@RequestBody User u){
        try {
            User user = userService.add(u);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/asCook/{userId}")
    public ResponseEntity<Cook> cookRegistration(@RequestBody Cook c, @PathVariable Long userId){
        try {
            Cook cook = cookServiceImpl.add(c, userId);
            return new ResponseEntity<>(cook, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
