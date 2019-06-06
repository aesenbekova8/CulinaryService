package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.repository.CookRepository;
import com.example.CulinaryService.repository.RolesRepository;
import com.example.CulinaryService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class CookServiceImpl implements CrudService<Cook>, CookService {
    @Autowired
    private CookRepository cookRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Cook add(Cook c, Long userId) {
        User user = userRepository.findById(userId).get();
        c.setUser(user);
        Roles role = new Roles("COOK");
//        Roles role = rolesRepository.findByRole("COOK");
        user.setRoles(new HashSet<Roles>(Arrays.asList(role)));
        return cookRepository.save(c);
    }

    @Override
    public Cook add(Cook cook) {

        return cookRepository.save(cook);
    }

    @Override
    public List<Cook> getAll() {
        return cookRepository.findAll();
    }

    @Override
    public Cook getById(Long id) {
        return cookRepository.findById(id).get();
    }

    @Override
    public Cook update(Cook cook) {
        return cookRepository.save(cook);
    }

    @Override
    public void delete(Long id) {
        cookRepository.deleteById(id);
    }
}
