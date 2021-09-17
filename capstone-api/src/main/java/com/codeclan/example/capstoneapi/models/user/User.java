package com.codeclan.example.capstoneapi.models.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "level")
    private int level;

    @Column(name = "currentXp")
    private double currentXp;

    @Column(name= "maximumXP")
    private double maximumXp;

    @Column(name = "health")
    private double health;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"user"})
    private List<Task> tasks;

    public User(String username, int level, double currentXp, double maximumXp,  double health) {
        this.username = username;
        this.level = level;
        this.currentXp = currentXp;
        this.maximumXp = maximumXp;
        this.health = health;
        this.tasks = new ArrayList<>();
    }

    public User(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean addTask(Task newTask){
        return this.tasks.add(newTask);
    }

    public double getCurrentXp() {
        return currentXp;
    }

    public void setCurrentXp(double currentXp) {
        this.currentXp = currentXp;
    }

    public double getMaximumXp() {
        return maximumXp;
    }

    public void setMaximumXp(double maximumXp) {
        this.maximumXp = maximumXp;
    }

    public void increaseXp(double amount) {
        currentXp += amount;
    }
}
