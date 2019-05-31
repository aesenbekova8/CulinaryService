package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.service.CookService;
import com.example.CulinaryService.service.CookServiceImpl;
import com.example.CulinaryService.service.CrudService;
import com.example.CulinaryService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private CookService cookService;

    @Autowired
    private CookServiceImpl cookServiceImpl;

    @PostMapping()
    public ResponseEntity<User> userRegistration(@RequestBody User u){
        try {
            User user = userService.registration(u);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cook")
    public ResponseEntity<Cook> cookRegistration(@RequestBody Cook c){
        try {
            Cook cook = cookServiceImpl.add(c);
            return new ResponseEntity<>(cook, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/cook/{id}")
//    public ResponseEntity<Cook> cookRegistration(@RequestBody Cook c, @PathVariable Long userId){
//        try {
//            Cook cook = cookService.cooRegistration(c, userId);
//            return new ResponseEntity<>(cook, HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
