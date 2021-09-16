package com.codeclan.example.capstoneapi.components;


import com.codeclan.example.capstoneapi.models.data.Contact;
import com.codeclan.example.capstoneapi.models.user.Task;
import com.codeclan.example.capstoneapi.models.user.User;
import com.codeclan.example.capstoneapi.repositories.ContactRepository;
import com.codeclan.example.capstoneapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    public DataLoader(){} //empty constructor

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    UserRepository userRepository;

    public void run(ApplicationArguments args){



        //methods go here
        //CONTACTS
        Contact testContact = new Contact(
                "Test Organisation",
                "call us if you need help mate we will help you for sure mate",
                123456789L,
                "helpU@gmail.com");

        Contact testContact2 = new Contact(
                "Only Name for this organisation no other properties",
                null,
                null,
                "appagandomate@gmail.com");

        contactRepository.save(testContact);
        contactRepository.save(testContact2);

        //CREATING USER

        User testUser = new User(
                "Someone",
                1,
                100,
                100
                );

        userRepository.save(testUser);

        //CREATING TASK

        Task testTaskOne = new Task(
                "Chores",
                "prepare food and clean dishes",
                false,
                testUser);
    }
}
