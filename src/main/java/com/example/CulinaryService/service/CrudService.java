package com.example.CulinaryService.service;

import java.util.List;

public interface CrudService<T> {
    T add(T t);
    List<T> getAll();
    T getById(Long id);
    T update(T t);
    void delete(Long id);
}
