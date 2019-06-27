package com.example.CulinaryService.bootstrap;


import com.example.CulinaryService.model.*;
import com.example.CulinaryService.repository.*;
import com.example.CulinaryService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private CookRepository cookRepository;

    @Override
    public void run(String... args) throws Exception {
        Roles roles1 = new Roles("ROLE_ADMIN");
        Roles roles2 = new Roles("ROLE_USER");
        Roles roles3 = new Roles("ROLE_COOK");
        roleCrudService.save(roles1);
        roleCrudService.save(roles2);
        roleCrudService.save(roles3);

        Category category1 = new Category("Китайская кухня");
        Category category2 = new Category("Русская кухня");
        Category category3 = new Category("Италианская кухня");
        Category category4 = new Category("Корейская кухня");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);

        Skill skill1 = new Skill(category1);
        Skill skill2 = new Skill(category2);
        Skill skill3 = new Skill(category3);
        Skill skill4 = new Skill(category4);
        skillRepository.save(skill1);
        skillRepository.save(skill2);
        skillRepository.save(skill3);
        skillRepository.save(skill4);

        List<Skill> skills1 = new ArrayList<>();
        skills1.add(skill1);
        skills1.add(skill2);
        skills1.add(skill4);

        List<Skill> skills2 = new ArrayList<>();
        skills2.add(skill2);
        skills2.add(skill3);

        List<Skill> skills3 = new ArrayList<>();
        skills3.add(skill4);
        skills3.add(skill3);

        User user1 = new User("cook1", "Gordon James Ramsay", "+78450518354", "gordon@gmail.com", passwordEncoder.encode("123"));
        user1.setRoles(new HashSet<>(Arrays.asList(roles3)));
        user1.setActive(1);
        userRepository.save(user1);

        Cook cook1 = new Cook();
        cook1.setSkills(skills1);
        cook1.setUser(user1);
        cookRepository.save(cook1);

        User user2 = new User("cook2","Alain Ducasse", "+7897543168","alain@gmail.com", passwordEncoder.encode("123"));
        user2.setRoles(new HashSet<>(Arrays.asList(roles3)));
        user2.setActive(1);
        userCrudService.add(user2);

        Cook cook2 = new Cook();
        cook2.setSkills(skills2);
        cook2.setUser(user2);
        cookRepository.save(cook2);

        User user3 = new User("cook3", "Matsuhisa Nobuyuki", "+46445313545","nobuyuki@gmail.com", passwordEncoder.encode("123"));
        user2.setRoles(new HashSet<>(Arrays.asList(roles3)));
        user3.setActive(1);
        userCrudService.add(user3);

        Cook cook3 = new Cook();
        cook3.setSkills(skills3);
        cook3.setUser(user3);
        cookRepository.save(cook3);

        User user4 = new User();
        user4.setActive(1);
        user4.setRoles(new HashSet<>(Arrays.asList(roles2)));
        user4.setName("user");
        user4.setLastName("4");
        user4.setPhoneNo("+54512348645");
        user4.setEmail("user4@gmail.com");
        user4.setPassword(passwordEncoder.encode("123"));
        userRepository.save(user4);

        User user5 = new User();
        user5.setActive(1);
        user5.setRoles(new HashSet<>(Arrays.asList(roles2)));
        user5.setName("user5");
        user5.setLastName("5");
        user5.setPhoneNo("+687543682");
        user5.setEmail("user5@gmail.com");
        user5.setPassword(passwordEncoder.encode("123"));
        userRepository.save(user5);

        User user6 = new User();
        user6.setActive(1);
        user6.setRoles(new HashSet<>(Arrays.asList(roles1)));
        user6.setName("user6");
        user6.setLastName("6");
        user6.setPhoneNo("+13541341341");
        user6.setEmail("user6@gmail.com");
        user6.setPassword(passwordEncoder.encode("123"));
        userRepository.save(user6);
    }
}

//user6 - ADMIN
//user5, user4 - USER
//user1, user2, user3 - COOK
//user7 - USER
