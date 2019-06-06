package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Cook;

public interface CookService {
    Cook add(Cook c, Long userId);
}
