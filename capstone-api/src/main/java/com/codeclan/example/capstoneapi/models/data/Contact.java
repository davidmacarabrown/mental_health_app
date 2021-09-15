package com.codeclan.example.capstoneapi.models.data;

import org.springframework.data.annotation.Id;

public class Contact {

    @Id
    private String id;

    private String name;

    private String description;

    private int number;

    private String email;

    public Contact(String id, String name, String description, int number, String email){
        this.id = id;
        this.name = name;
        this.description = description;
        this.number = number;
        this.email = email;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
