package com.example.CulinaryService.service;

import com.example.CulinaryService.entity.Search;
import com.example.CulinaryService.helpers.Helper;
import com.example.CulinaryService.model.*;
import com.example.CulinaryService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CookServiceImpl implements CrudService<Cook>, CookService {
    @Autowired
    private CookRepository cookRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private Helper helper;

    @Override
    public List<Cook> getAllCooks() {
        return cookRepository.getAllCooksByRating();
    }

    @Override
    public Cook rateCook(Mark mark, Long cookId) {
        User user = userRepository.findById(helper.getCurrentUser().getId()).get();
        Cook cook = cookRepository.findById(cookId).get();
        mark.setUser(user);
        mark.setCook(cook);
        markRepository.save(mark);
        List<Mark> marks = cook.getMarks();
        boolean allow = true;
        for (Mark m : marks){
            if (m.getUser().equals(user)){
                allow = false;
                break;
            }
        }
        if (allow){
            mark.setUser(user);
            mark.setCook(cook);
            markRepository.save(mark);
            marks.add(mark);
            cook.setMarks(marks);
            cook.setRating(cook.getRating() + 1);
            cookRepository.save(cook);
            return cook;
        }
        else {
            return null;
        }
    }

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
                    Cook cook = cookRepository.findById(cookId).get();
                    getCooks.add(cook);
                }
            }
        }
        return getCooks;
    }



    @Override
    public Cook add(Cook cook) {
        User user = userRepository.findById(helper.getCurrentUser().getId()).get();
        cook.setUser(user);
        Roles role = rolesRepository.findByName("ROLE_COOK");
        Set<Roles> roles = user.getRoles();
        roles.add(role);
        user.setRoles(roles);
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
