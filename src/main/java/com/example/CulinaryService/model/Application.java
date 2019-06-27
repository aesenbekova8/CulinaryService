package com.example.CulinaryService.model;

import javax.persistence.*;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Cook cook;

    private boolean withDeparture;

    private boolean withProducts;

    private boolean confirm;

    public Application() {
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

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public boolean isWithDeparture() {
        return withDeparture;
    }

    public void setWithDeparture(boolean withDeparture) {
        this.withDeparture = withDeparture;
    }

    public boolean isWithProducts() {
        return withProducts;
    }

    public void setWithProducts(boolean withProducts) {
        this.withProducts = withProducts;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }
}
