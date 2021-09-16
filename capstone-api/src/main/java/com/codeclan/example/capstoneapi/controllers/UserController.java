package com.codeclan.example.capstoneapi.controllers;


import com.codeclan.example.capstoneapi.models.user.User;

import com.codeclan.example.capstoneapi.repositories.AppDataRepository;
import com.codeclan.example.capstoneapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppDataRepository appDataRepository;

    //User ROUTES

    //creates new User in DB
    @PostMapping(value = "/users")
    //create response entity variable & take new User object from the RequestBody
    public ResponseEntity<User> saveNewUser(@RequestBody User newUser){
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    //returns User by their unique ID
    @GetMapping(value= "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    //deletes User by ID
    @DeleteMapping(value = "/users/{id}")
    // question mark means an empty response entity can be sent back with just the HTTP Status?
    public ResponseEntity deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update User by ID
    @PatchMapping(value = "/users/{id}") //find One byID first, set each property, then insert
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser){

        User foundUser = userRepository.findById(id).get();

        foundUser.setHealth(updatedUser.getHealth());
        foundUser.setLevel(updatedUser.getLevel());
        foundUser.setUsername(updatedUser.getUsername());
        foundUser.setXp(updatedUser.getXp());
        foundUser.setHealth(updatedUser.getHealth());

        userRepository.save(updatedUser);
        return new ResponseEntity(updatedUser, HttpStatus.OK); //
    }
}
