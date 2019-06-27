package com.example.CulinaryService.model;


import javax.persistence.*;


@Entity
@Table(name = "role1")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roles_id")
    private Long id;

    @Column(name = "role")
    private String name;

    public Roles() {
    }

    public Roles(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
