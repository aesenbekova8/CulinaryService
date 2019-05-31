package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Cook;

public interface CookService {
    Cook cooRegistration(Cook c, Long userId);
}
