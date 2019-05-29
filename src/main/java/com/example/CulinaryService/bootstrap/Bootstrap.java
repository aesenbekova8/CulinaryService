package com.example.CulinaryService.bootstrap;


import com.example.CulinaryService.model.*;
import com.example.CulinaryService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private UserService userCrudService;

    @Autowired
    private CookServiceImpl cookService;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private ChatServiceImpl chatService;

    @Autowired
    private RolesServiceImpl roleCrudService;

    @Override
    public void run(String... args) throws Exception {
        Roles roles = new Roles("ADMIN");
        Roles roles2 = new Roles("USER");
        roleCrudService.add(roles);
        roleCrudService.add(roles2);
        //, new HashSet<Role> (Arrays.asList(role2))

        User user1 = new User("@user1");
        userCrudService.add(user1);

        User user2 = new User("@user2");
        userCrudService.add(user2);

        User user3 = new User("@user3");
        userCrudService.add(user3);

        Cook cook1 = new Cook("COOK1", user1);
        cookService.add(cook1);

        Cook cook2 = new Cook("COOK2", user2);
        cookService.add(cook2);

        Cook cook3 = new Cook("COOK3", user3);
        cookService.add(cook3);

        Message message1 = new Message(user1, user2, "Hello!");
        messageService.add(message1);

        Message message2 = new Message(user2, user1, "Hi!");
        messageService.add(message2);

        Message message3 = new Message(user1, user2, "How are you?");
        messageService.add(message3);

        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);

        Chat chat1 = new Chat(user1, messages);
        chatService.add(chat1);
    }
}
