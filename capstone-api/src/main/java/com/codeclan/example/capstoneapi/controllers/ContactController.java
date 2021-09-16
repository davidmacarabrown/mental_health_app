package com.codeclan.example.capstoneapi.controllers;

import com.codeclan.example.capstoneapi.models.data.Contact;
import com.codeclan.example.capstoneapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    //get all contacts
    @GetMapping(value = "/contacts")
    public ResponseEntity<List<Contact>> getAllContacts(){
        return new ResponseEntity<>(contactRepository.findAll(), HttpStatus.OK);
    }
}
