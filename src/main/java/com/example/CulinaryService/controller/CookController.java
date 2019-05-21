package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cook")
public class CookController {
    @Autowired
    private CrudService<Cook> cookCrudService;

    @PostMapping(path = "/add", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Cook> add(@RequestBody Cook u){
        Cook Cook = this.cookCrudService.add(u);
        try {
            return new ResponseEntity<>(Cook, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Cook> getAll(){
        return this.cookCrudService.getAll();
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Cook> getById(@PathVariable Long id){
        Cook Cook = this.cookCrudService.getById(id);
        try {
            return new ResponseEntity<>(Cook, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Cook> delete(@PathVariable Long id){
        try {
            this.cookCrudService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
