package com.codeclan.example.capstoneapi.models.services;

import com.codeclan.example.capstoneapi.models.user.Task;
import com.codeclan.example.capstoneapi.models.user.User;

import java.util.ArrayList;
import java.util.List;

public class Aggregate {

    private User user;
    private List<Task> tasks;

    public Aggregate(User user, List<Task> tasks) {
        this.user = user;
        this.tasks = tasks;
    }

    public Aggregate(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
