package com.example.CulinaryService.repository;

import com.example.CulinaryService.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rolesRepository")
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String role);
}
