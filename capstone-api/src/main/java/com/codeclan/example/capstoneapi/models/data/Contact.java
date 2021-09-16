package com.codeclan.example.capstoneapi.models.data;

import javax.persistence.*;

@Entity
@Table(name="contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="organisation", nullable = false)
    private String organisation;

    @Column(name="description")
    private String description;

    @Column(name="number")
    private Long number;

    @Column(name="email")
    private String email;

    //TODO research default values setting them to null

    public Contact(String organisation, String description, Long number, String email){
        this.organisation = organisation;
        this.description = description;
        this.number = number;
        this.email = email;
    }

    public Contact(){}

    public String getName() {
        return organisation;
    }

    public void setName(String name) {
        this.organisation = name;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
