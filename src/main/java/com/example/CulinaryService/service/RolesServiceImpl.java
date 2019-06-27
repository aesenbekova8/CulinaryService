package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl {
    @Autowired
    private RolesRepository rolesRepository;

    public Roles add(Roles r){
        return rolesRepository.save(r);
    }
}
