package com.example.CulinaryService.service;

import com.example.CulinaryService.model.Application;

import java.util.List;

public interface ApplicationService {
    Application apply(Application application, Long cookId);
    Application confirm(Long appId);
    List<Application> getAllApp();
    List<Application> getAllConfirmApp();
}
