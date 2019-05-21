package com.example.CulinaryService.bootstrap;

import com.example.CulinaryService.enums.Role;
import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Message;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.service.CookServiceImpl;
import com.example.CulinaryService.service.CrudService;
import com.example.CulinaryService.service.MessageServiceImpl;
import com.example.CulinaryService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private UserService userCrudService;

    @Autowired
    private CookServiceImpl cookService;

    @Autowired
    private MessageServiceImpl messageService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("user1", "111", "@user1", Role.USER, "123", 2);
        userCrudService.add(user1);

        User user2 = new User("user2", "222", "@user2", Role.ADMIN, "123", 5);
        userCrudService.add(user2);

        User user3 = new User("user3", "333", "@user3", Role.COOK, "123", 1);
        userCrudService.add(user3);

        Cook cook1 = new Cook("COOK1");
        cookService.add(cook1);

        Cook cook2 = new Cook("COOK2");
        cookService.add(cook2);

        Cook cook3 = new Cook("COOK3");
        cookService.add(cook3);

        Message message1 = new Message(user1, "Hello!");
        messageService.add(message1);

        Message message2 = new Message(user2, "Hi!");
        messageService.add(message2);

        Message message3 = new Message(user3, "How are you?");
        messageService.add(message3);
    }
}
