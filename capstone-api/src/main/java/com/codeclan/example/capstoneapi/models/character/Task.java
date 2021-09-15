package com.codeclan.example.capstoneapi.models.character;

import org.springframework.data.annotation.Id;

public class Task {

    private String name;

    private String description;

    private Boolean completed;


    public Task(String name, String description, Boolean completed) {
        this.name = name;
        this.description = description;
        this.completed = completed;
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