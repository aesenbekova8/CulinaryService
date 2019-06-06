package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Order;
import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.repository.CookRepository;
import com.example.CulinaryService.repository.OrderRepository;
import com.example.CulinaryService.repository.RolesRepository;
import com.example.CulinaryService.repository.UserRepository;
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
    public List<Order> getAllOrders(Long userId) {
        User user = userRepository.findById(userId).get();
        List<Order> orders = user.getOrders();
        return orders;
    }

    @Override
    public Order madeOrder(Order order, Long userId, Long cookId) {
        User user = userRepository.findById(userId).get();
        Cook cook = cookRepository.findById(cookId).get();
        order.setCook(cook);
        order.setUser(user);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
    //        user.setOrders(orders);
        userRepository.save(user);
        orderRepository.save(order);
        return order;
    }

    @Override
    public User add(User user) {
        user.setActive(1);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Roles userRole = new Roles("USER");
//        Roles userRole = rolesRepository.findByRole("USER");
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
