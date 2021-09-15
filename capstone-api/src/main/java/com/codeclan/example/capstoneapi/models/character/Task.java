package com.codeclan.example.capstoneapi.models.character;

import org.springframework.data.annotation.Id;

public class Task {

    @Id
    private String id;

    private String name;

    private String description;

    private Boolean completed;


    public Task(String name, String description, Boolean completed) {
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}