package com.example.CulinaryService.controller;

import com.example.CulinaryService.model.Order;
import com.example.CulinaryService.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private CrudService<Order> orderCrudService;

    @PostMapping("/add")
    public ResponseEntity<Order> add(@RequestBody Order o){
        try {
            Order order = orderCrudService.add(o);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public List<Order> getAll(){
           return orderCrudService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id){
        try {
            Order order = orderCrudService.getById(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            orderCrudService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
