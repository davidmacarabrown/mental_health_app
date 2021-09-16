package com.codeclan.example.capstoneapi.models.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "level")
    private int level;

    @Column(name = "xp")
    private int xp;

    @Column(name = "health")
    private int health;

    @OneToMany(mappedBy = "character", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"character"})
    private List<Task> tasks;

    public Character(String username, int level, int xp, int health) {
        this.username = username;
        this.level = level;
        this.xp = xp;
        this.health = health;
        this.tasks = new ArrayList<>();
    }

    public Character(){};

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

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean addTask(Task newTask){
        return this.tasks.add(newTask);
    }
}
