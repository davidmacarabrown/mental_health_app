package com.codeclan.example.capstoneapi.models.data;


public class Contact {



    private String name;

    private String description;

    private Long number;

    private String email;

    public Contact(String name, String description, Long number, String email){
        this.name = name;
        this.description = description;
        this.number = number;
        this.email = email;
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
