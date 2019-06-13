package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Skill findByCategory(String category);
}
