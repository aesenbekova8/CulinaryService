package com.example.CulinaryService.repository;

import com.example.CulinaryService.entity.Search;
import com.example.CulinaryService.model.Cook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CookRepository extends JpaRepository<Cook, Long> {
    @Query(value = "select id, rating, users_id from cook order by rating desc", nativeQuery=true)
    List<Cook> getAllCooksByRating();
}
