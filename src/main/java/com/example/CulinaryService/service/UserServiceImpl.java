package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.repository.RolesRepository;
import com.example.CulinaryService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements CrudService<User>, UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public User registration(User u) {
        Roles role = new Roles("USER");
        HashSet<Roles> roles = new HashSet<>();
        roles.add(role);
        rolesRepository.save(role);
        User user = userRepository.save(u);
        user.setRoles(roles);
//        roles.stream().map(i -> i.getName().equals("USER")).findFirst().get();
        return userRepository.save(u);
    }

    @Override
    public Set<Roles> roleDefinition(User u) {
        User user = userRepository.save(u);
        HashSet<Roles> roles = new HashSet<>();
        roles.add(new Roles("USER"));
        user.setRoles(roles);
        roles.stream().map(i -> i.getName().equals("USER")).findFirst().get();
        return null;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
