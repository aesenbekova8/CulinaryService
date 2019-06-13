package com.example.CulinaryService.controller;

import com.example.CulinaryService.entity.Search;
import com.example.CulinaryService.model.Cook;
import com.example.CulinaryService.model.Mark;
import com.example.CulinaryService.service.CookService;
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

    @Autowired
    private CookService cookService;

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Cook> getAll(){
        return this.cookCrudService.getAll();
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Cook> getById(@PathVariable Long id){
        Cook cook = this.cookCrudService.getById(id);
        try {
            return new ResponseEntity<>(cook, HttpStatus.OK);
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

    @GetMapping("/getByCategory")
    public List<Cook> getByCategory(@RequestBody Search search){
        return cookService.findByCategory(search);
    }

    @GetMapping("/getAllCooks")
    public List<Cook> getAllCooks(){
        return cookService.getAllCooks();
    }

    @PostMapping("/rateCook/{userId}/{cookId}")
    public ResponseEntity<Cook> rateCook(@RequestBody Mark mark,
                                         @PathVariable Long userId,
                                         @PathVariable Long cookId){
        try {
            Cook cook = cookService.rateCook(mark, userId, cookId);
            return new ResponseEntity<>(cook, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
