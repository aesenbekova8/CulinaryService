package com.example.CulinaryService.bootstrap;

import com.example.CulinaryService.enums.Role;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.service.CrudService;
import com.example.CulinaryService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private UserService userCrudService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("user1", "111", "@user1", Role.USER, "123", 2);
        userCrudService.add(user1);

        User user2 = new User("admin1", "222", "@admin1", Role.ADMIN, "123", 5);
        userCrudService.add(user2);

        User user3 = new User("cook1", "333", "@cook1", Role.COOK, "123", 1);
        userCrudService.add(user3);
    }
}
