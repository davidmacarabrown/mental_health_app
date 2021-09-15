package com.codeclan.example.capstoneapi.components;

import com.codeclan.example.capstoneapi.controllers.ContactController;
import com.codeclan.example.capstoneapi.models.data.Contact;
import com.codeclan.example.capstoneapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ContactRepository contactRepository; //import the contactRepository

    public DataLoader(){} //empty constructor

    public void run(ApplicationArguments args){

        //methods go here

        contactRepository.deleteAll();

        Contact contactOne = new Contact("Helpline", "please call us for help", 1234567890L, "appagandomate@gmail.com");
        contactRepository.save(contactOne);

        Contact contactTwo = new Contact("another helpline", "call if you need any assistance", 1122334455L, "asdf@helpme.com");
        contactRepository.save(contactTwo);
    }

}
