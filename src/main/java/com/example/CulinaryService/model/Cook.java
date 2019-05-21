package com.example.CulinaryService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNo;

    private String password;

    private String skills;

    private int rating;

    private boolean withDeparture;

    public Cook() {
    }

    public Cook(String name) {
        this.name = name;
    }

    public Cook(String name, String phoneNo, String password, String skills, int rating, boolean withDeparture) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.password = password;
        this.skills = skills;
        this.rating = rating;
        this.withDeparture = withDeparture;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isWithDeparture() {
        return withDeparture;
    }

    public void setWithDeparture(boolean withDeparture) {
        this.withDeparture = withDeparture;
    }
}
