package com.example.CulinaryService.bootstrap;


import com.example.CulinaryService.model.*;
import com.example.CulinaryService.repository.OrderRepository;
import com.example.CulinaryService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private UserServiceImpl userCrudService;

    @Autowired
    private CookServiceImpl cookService;

    @Autowired
    private RolesServiceImpl roleCrudService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Roles roles = new Roles("ADMIN");
        Roles roles2 = new Roles("USER");
        Roles roles3 = new Roles("COOK");
        roleCrudService.add(roles);
        roleCrudService.add(roles2);
        roleCrudService.add(roles3);

        User user1 = new User("user1@mail.ru","user1", "123");
        userCrudService.add(user1);

        User user2 = new User("user2@mail.ru","user2", "123");
        userCrudService.add(user2);

        User user3 = new User("user3@mail.ru", "user3","123");
        userCrudService.add(user3);

        Cook cook1 = new Cook(user1);
        cookService.add(cook1);

        Cook cook2 = new Cook(user2);
        cookService.add(cook2);

        Cook cook3 = new Cook(user3);
        cookService.add(cook3);

        Order order1 = new Order(user1, cook2);
        Order order2 = new Order(user3, cook2);
        Order order3 = new Order(user1, cook1);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
//
//        Message message1 = new Message(user1, user2, "Hello!");
//        messageService.add(message1);
//
//        Message message2 = new Message(user2, user1, "Hi!");
//        messageService.add(message2);
//
//        Message message3 = new Message(user1, user2, "How are you?");
//        messageService.add(message3);
//
//        List<Message> messages = new ArrayList<>();
//        messages.add(message1);
//        messages.add(message2);
//        messages.add(message3);
//
//        Chat chat1 = new Chat(user1, messages);
//        chatService.add(chat1);
//
//        Order order1 = new Order(user1, cook1);
//        orderCrudService.add(order1);
//        Order order2 = new Order(user2, cook2);
//        orderCrudService.add(order2);
    }
}
