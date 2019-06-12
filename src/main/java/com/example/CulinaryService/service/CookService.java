package com.example.CulinaryService.service;

import com.example.CulinaryService.entity.Search;
import com.example.CulinaryService.model.Cook;

import java.util.List;

public interface CookService {
    Cook add(Cook c, Long userId);
    List<Cook> findByCategory(Search search);
}
