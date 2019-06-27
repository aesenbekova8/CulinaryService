package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Application;
import com.example.CulinaryService.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/app")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/{cookId}/app")
    public ResponseEntity<Application> app(@RequestBody Application application,
                                           @PathVariable Long cookId){
        try {
            Application application1 = applicationService.apply(application, cookId);
            return new ResponseEntity<>(application1, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{appId}/confirm")
    public ResponseEntity<Application> confirm(@PathVariable Long appId){
        try {
            Application application = applicationService.confirm(appId);
            return new ResponseEntity<>(application, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public List<Application> getAll(){
        return applicationService.getAllApp();
    }

    @GetMapping("/getAllConfirmApp")
    public List<Application> getAllConfirmApp(){
        return applicationService.getAllConfirmApp();
    }
}
