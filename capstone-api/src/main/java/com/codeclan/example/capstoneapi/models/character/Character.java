package com.codeclan.example.capstoneapi.models.character;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Character {

    @Id
    private String id;

    private String username;

    private int level;

    private int xp;

    private int health;

    private ArrayList<Task> tasks;

    public Character(String username, int level, int xp, int health, ArrayList<Task> tasks) {
        this.username = username;
        this.level = level;
        this.xp = xp;
        this.health = health;
        this.tasks = new ArrayList<>();
    }

    public Character(){};

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
