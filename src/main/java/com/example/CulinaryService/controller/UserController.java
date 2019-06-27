package com.example.CulinaryService.controller;

import com.example.CulinaryService.helpers.Helper;
import com.example.CulinaryService.model.*;
import com.example.CulinaryService.repository.OrderRepository;
import com.example.CulinaryService.service.CookService;
import com.example.CulinaryService.service.CrudService;
import com.example.CulinaryService.service.UserService;
import com.example.CulinaryService.service.UserServiceImpl;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CrudService<User> userCrudService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CookService cookService;

    @Autowired
    private Helper helper;

    @GetMapping("/getAll")
    public List<User> getAll(){
            return this.userCrudService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user = this.userCrudService.getById(id);
        try {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> delete(@PathVariable Long id){
        try {
            this.userCrudService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<User> getByName(@PathVariable String name,  User u){
        try {
            User user = userService.getByName(name, u);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{cookId}/add")
    public Set<Cook> addToFavorites(@PathVariable Long cookId){
        return userService.addToFavorites(cookId);
    }

    @GetMapping("/favorites")
    public Set<Cook> favorites(){
        return userService.getAllFavorites();
    }
}
