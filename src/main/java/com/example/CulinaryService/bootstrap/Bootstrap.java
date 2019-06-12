package com.example.CulinaryService.bootstrap;


import com.example.CulinaryService.model.*;
import com.example.CulinaryService.repository.*;
import com.example.CulinaryService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CrudService<User> userCrudService;

    @Autowired
    private CrudService<Cook> cookService;

    @Autowired
    private RolesRepository roleCrudService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public void run(String... args) throws Exception {
        Roles roles = new Roles("ROLE_ADMIN");
        Roles roles2 = new Roles("ROLE_USER");
        Roles roles3 = new Roles("ROLE_COOK");
        roleCrudService.save(roles);
        roleCrudService.save(roles2);
        roleCrudService.save(roles3);

        Category category1 = new Category("Китайская кухня");
        Category category2 = new Category("Русская кухня");
        Category category3 = new Category("name");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        Skill skill1 = new Skill(category1);
        Skill skill2 = new Skill(category2);
        Skill skill3 = new Skill(category3);
        skillRepository.save(skill1);
        skillRepository.save(skill2);
        skillRepository.save(skill3);

        User user1 = new User("user1", "Gordon James Ramsay", "+78450518354", "gordon@gmail.com", "123");
        userCrudService.add(user1);

        User user2 = new User("user2","Alain Ducasse", "+7897543168","alain@gmail.com", "123");
        userCrudService.add(user2);

        User user3 = new User("user3", "Matsuhisa Nobuyuki", "+46445313545","nobuyuki@gmail.com", "123");
        userCrudService.add(user3);

        Cook cook1 = new Cook(user1, new ArrayList<Skill>(Arrays.asList( skill3)));
        cookService.add(cook1);

        Cook cook2 = new Cook(user2, new ArrayList<Skill>(Arrays.asList(skill3, skill2)));
        cookService.add(cook2);

        Cook cook3 = new Cook(user3, new ArrayList<Skill>(Arrays.asList(skill1, skill2)));
        cookService.add(cook3);

        Cook cook4 = new Cook(user1, new ArrayList<Skill>(Arrays.asList(skill1, skill3)));
        cookService.add(cook1);

//        Order order1 = new Order(user1, cook2);
//        Order order2 = new Order(user3, cook2);
//        Order order3 = new Order(user1, cook1);
//        orderRepository.save(order1);
//        orderRepository.save(order2);
//        orderRepository.save(order3);
//
        Message message1 = new Message(user1, user2, "Hello!");
        messageRepository.save(message1);

        Message message2 = new Message(user2, user1, "Hi!");
        messageRepository.save(message2);

        Message message3 = new Message(user1, user2, "How are you?");
        messageRepository.save(message3);
//
        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
//
        Chat chat1 = new Chat(user1, messages);
        chatRepository.save(chat1);
//
//        Order order1 = new Order(user1, cook1);
//        orderCrudService.add(order1);
//        Order order2 = new Order(user2, cook2);
//        orderCrudService.add(order2);
    }
}
