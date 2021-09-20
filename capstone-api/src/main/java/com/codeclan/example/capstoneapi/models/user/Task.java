package com.codeclan.example.capstoneapi.models.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name= "description")
    private String description;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
//    @JsonIgnoreProperties({"tasks"})
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;


    public Task(String name, String description, Boolean status, User user) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public Task(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void markComplete(){
        this.status = true;
    }

    public void markIncomplete(){
        this.status = false;
    }

    public Long getId(){
        return this.id;
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
}