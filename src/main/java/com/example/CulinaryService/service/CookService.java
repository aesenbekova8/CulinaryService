package com.example.CulinaryService.service;

import com.example.CulinaryService.entity.Search;
import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Mark;

import java.util.List;

public interface CookService {
    Cook add(Cook c, Long userId);
    List<Cook> findByCategory(Search search);
    Cook rateCook(Mark mark, Long userId, Long cookId);
    List<Cook> getAllCooks();
}
