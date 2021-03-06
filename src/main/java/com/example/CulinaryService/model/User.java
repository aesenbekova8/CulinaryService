package com.example.CulinaryService.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "users_id")
    private Long id;

//    @NotEmpty
    private String name;

    private String lastName;

//    @NotEmpty
    private String phoneNo;

    @Column(name = "email")
    @Email
//    @NotEmpty
    private String email;

    @ManyToMany
    @JsonIgnore

    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles;

    @Length(min = 3)
//    @NotEmpty
    private String password;

    private int active;

    @OneToMany
    @JsonIgnore
//    @JoinTable(name = "orders_id")
    private List<Order> orders;

    @OneToMany
    @JsonIgnore
    private Set<Cook> favorites;

    @OneToMany
    @JsonIgnore
    private List<Chat> chats;

    public User() {
    }

    public User(String name, String lastName, String phoneNo, @Email String email, @Length(min = 3) String password) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Set<Cook> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Cook> favorites) {
        this.favorites = favorites;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}
