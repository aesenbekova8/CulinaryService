package com.example.CulinaryService.service;

import com.example.CulinaryService.model.*;
import com.example.CulinaryService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements CrudService<User>, UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CookRepository cookRepository;
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByName(String name, User user){
        List<User> users = userRepository.findAll();
        for (User u : users){
            if (u.getName().equals(name)){
                user = u;
            }
        }
        return user;
    }

    @Override
    public User add(User user) {
        user.setActive(1);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Roles userRole = new Roles("USER");
        Roles userRole = rolesRepository.findByName("ROLE_USER");
        rolesRepository.save(userRole);
        user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
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
