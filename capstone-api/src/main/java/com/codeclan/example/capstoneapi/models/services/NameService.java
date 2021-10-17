package com.codeclan.example.capstoneapi.models.services;

public class NameService {

    private String username;

    public NameService(String username){
        this.username = username;
    }

    public NameService(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
