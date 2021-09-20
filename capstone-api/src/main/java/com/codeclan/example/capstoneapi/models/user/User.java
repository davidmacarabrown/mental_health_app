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
    private int currentXp;

    @Column(name= "maximumXP")
    private int maximumXp;

    @Column(name = "health")
    private int health;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @JsonIgnoreProperties({"user"})
    @JsonBackReference
    private List<Task> tasks;

    public User(String username, int level, int currentXp, int maximumXp,  int health) {
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

    public void increaseLevel(){
        this.level += 1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean addTask(Task newTask){
        return this.tasks.add(newTask);
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public void setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
    }

    public int getMaximumXp() {
        return maximumXp;
    }

    public void setMaximumXp(int maximumXp) {
        this.maximumXp = maximumXp;
    }

    public void increaseXp(int amount) {
        currentXp += amount;
    }
}
