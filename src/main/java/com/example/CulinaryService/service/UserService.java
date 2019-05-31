package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.model.User;

import java.util.Set;

public interface UserService {
    User registration(User u);
    Set<Roles> roleDefinition(User u);
}
