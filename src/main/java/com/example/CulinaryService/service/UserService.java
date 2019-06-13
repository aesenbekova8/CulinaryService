package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Order;
import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User getByName(String name, User user);
    User getByEmail(String email);
}
