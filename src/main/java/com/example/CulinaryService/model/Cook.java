package com.example.CulinaryService.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_id")
    private User user;

    private String skills;

    private int rating;

    private boolean withDeparture;

    public Cook() {
    }

    public Cook(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
