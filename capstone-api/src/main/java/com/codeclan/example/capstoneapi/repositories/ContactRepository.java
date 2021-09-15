package com.codeclan.example.capstoneapi.repositories;

import com.codeclan.example.capstoneapi.models.data.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository <Contact, String>{
    public List<Contact> findAll();
}
