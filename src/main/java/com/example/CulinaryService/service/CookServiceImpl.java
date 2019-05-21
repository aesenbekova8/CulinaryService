package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.repository.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookServiceImpl implements CrudService<Cook> {
    @Autowired
    private CookRepository cookRepository;

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
