package com.codeclan.example.capstoneapi.models.user;


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

    @Column(name = "completed")
    private Boolean completed;

    @ManyToOne
    @JsonIgnoreProperties({"task"})
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;


    public Task(String name, String description, Boolean completed, Character character) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.character = character;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}