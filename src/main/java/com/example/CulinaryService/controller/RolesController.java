package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Roles;
import com.example.CulinaryService.service.CrudService;
import com.example.CulinaryService.service.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RolesController {
    @Autowired
    private RolesServiceImpl rolesService;

    @PostMapping(path = "/add", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Roles> add(@RequestBody Roles u){
        Roles Roles = this.rolesService.add(u);
        try {
            return new ResponseEntity<>(Roles, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
