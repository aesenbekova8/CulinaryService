package com.example.CulinaryService.service;

import com.example.CulinaryService.entity.Search;
import com.example.CulinaryService.model.*;
import com.example.CulinaryService.repository.CategoryRepository;
import com.example.CulinaryService.repository.CookRepository;
import com.example.CulinaryService.repository.RolesRepository;
import com.example.CulinaryService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Cook> findByCategory(Search search) {
        List<Cook> cooks = cookRepository.findAll();
        List<Cook> getCooks = new ArrayList<>();
        Category category = categoryRepository.findByName(search.getSearch());
        Long cookId = null;
        for (Cook c : cooks){
            for (Skill s : c.getSkills()){
                if (s.getCategory().getId() == category.getId()){
                    cookId = c.getId();
                }
            }
        }
        Cook cook = cookRepository.findById(cookId).get();
        getCooks.add(cook);
        cookRepository.save(cook);
        return getCooks;
    }

    @Override
    public Cook add(Cook c, Long userId) {
        User user = userRepository.findById(userId).get();
        c.setUser(user);
        Roles role = rolesRepository.findByName("ROLE_COOK");
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
