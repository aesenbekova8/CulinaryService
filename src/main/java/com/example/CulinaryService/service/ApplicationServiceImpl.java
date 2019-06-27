package com.example.CulinaryService.service;

import com.example.CulinaryService.helpers.Helper;
import com.example.CulinaryService.model.Application;
import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.User;
import com.example.CulinaryService.repository.ApplicationRepository;
import com.example.CulinaryService.repository.CookRepository;
import com.example.CulinaryService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private Helper helper;

    @Override
    public List<Application> getAllApp() {
        Cook cook = cookRepository.findById(helper.getCurrentUser().getId()).get();
        List<Application> allApp = cook.getApplications();
        return allApp;
    }

    @Override
    public List<Application> getAllConfirmApp() {
        Cook cook = cookRepository.findById(helper.getCurrentUser().getId()).get();
        List<Application> allConfirmApp = cook.getConfirmApp();
        return allConfirmApp;
    }

    @Override
    public Application confirm(Long appId) {
        Application application = applicationRepository.findById(appId).get();
        Cook cook = cookRepository.findById(helper.getCurrentUser().getId()).get();
        List<Application> applications = cook.getApplications();
        List<Application> confirmApp = cook.getConfirmApp();

        for (Application a : applications){
            if (a.getCook().getId() == cook.getId()){
                application.setConfirm(true);
                applicationRepository.save(application);
                cookRepository.save(cook);
            }
            else {
                application.setConfirm(false);
            }
        }

        if (application.isConfirm() == true){
            confirmApp.add(application);
            cookRepository.save(cook);
        }

        return application;
    }

    @Override
    public Application apply(Application application, Long cookId) {
        User user = userRepository.findById(helper.getCurrentUser().getId()).get();
        Cook cook = cookRepository.findById(cookId).get();
        application.setUser(user);
        application.setCook(cook);
        applicationRepository.save(application);
        List<Application> applications = cook.getApplications();
        applications.add(application);
        cookRepository.save(cook);
        return application;
    }
}
