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
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private CrudService<Roles> rolesService;

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

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Roles> getAll(){
        return this.rolesService.getAll();
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Roles> getById(@PathVariable Long id){
        Roles Roles = this.rolesService.getById(id);
        try {
            return new ResponseEntity<>(Roles, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Roles> delete(@PathVariable Long id){
        try {
            this.rolesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
