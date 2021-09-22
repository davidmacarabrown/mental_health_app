package com.codeclan.example.capstoneapi.models.user;

import java.util.ArrayList;
import java.util.List;

public class Aggregate {

    private String username;
    private int level;
    private int currentXp;
    private int maximumXp;
    private int health;
    private List<Task> tasks;

    public Aggregate(String username, int level, int currentXp, int maximumXp, int health) {
        this.username = username;
        this.level = level;
        this.currentXp = currentXp;
        this.maximumXp = maximumXp;
        this.health = health;
        this.tasks = new ArrayList<>();
    }

    public Aggregate(){}

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public int getMaximumXp() {
        return maximumXp;
    }

    public int getHealth() {
        return health;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
    }

    public void setMaximumXp(int maximumXp) {
        this.maximumXp = maximumXp;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
