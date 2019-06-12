package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Skill;
import com.example.CulinaryService.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
public class SkillContrroller {
    @Autowired
    private SkillRepository skillRepository;

    @PostMapping("/add")
    public ResponseEntity<Skill> add(@RequestBody Skill s){
        try {
            Skill skill = skillRepository.save(s);
            return new ResponseEntity<>(skill, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
