package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements CrudService<Roles> {
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles add(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public List<Roles> getAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getById(Long id) {
        return rolesRepository.findById(id).get();
    }

    @Override
    public Roles update(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }
}
