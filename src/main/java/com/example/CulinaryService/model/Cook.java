package com.example.CulinaryService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToMany
    @JsonIgnore
//    @JoinTable(name = "cook_skill",
//            joinColumns = @JoinColumn(name = "cook_id"),
//            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    @ManyToMany
    @JsonIgnore
//    @JoinTable(name = "cook_mark",
//            joinColumns = @JoinColumn(name = "cook_id"),
//            inverseJoinColumns = @JoinColumn(name = "mark_id"))
    private List<Mark> marks;

    private int rating;

    public Cook() {
    }

    public Cook(User user, List<Skill> skills) {
        this.user = user;
        this.skills = skills;
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


    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
