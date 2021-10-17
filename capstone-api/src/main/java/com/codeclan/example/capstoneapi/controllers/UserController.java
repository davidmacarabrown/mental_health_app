package com.codeclan.example.capstoneapi.controllers;


import com.codeclan.example.capstoneapi.models.data.AppData;
import com.codeclan.example.capstoneapi.models.services.NameService;
import com.codeclan.example.capstoneapi.models.user.User;

import com.codeclan.example.capstoneapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    AppData appData = new AppData();

    //User ROUTES

    //creates new User in DB
    @PostMapping(value = "/users")
    //create response entity variable & take new User object from the RequestBody
    public ResponseEntity<User> saveNewUser(@RequestBody NameService nameService){

        User newUser = new User(
                nameService.getUsername(),
                1,
                0,
                appData.getLevelOneXp(),
                appData.getStartingHealth()
        );

        userRepository.save(newUser);

        System.out.printf("New User created ID: %d %n", newUser.getId());

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    //returns User by their unique ID
    @GetMapping(value= "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        System.out.printf("User data retrieved ID: %d %n", id);
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    //deletes User by ID
    @DeleteMapping(value = "/users/{id}")
    // question mark means an empty response entity can be sent back with just the HTTP Status?
    public ResponseEntity deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        System.out.printf("User deleted ID: %d %n", id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update User by ID
    @PatchMapping(value = "/users/{id}") //find One byID first, set each property, then insert
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser){

        User foundUser = userRepository.findById(id).get();

        foundUser.setUsername(updatedUser.getUsername());

        userRepository.save(foundUser);
        System.out.printf("User updated ID: %d %n", id);
        return new ResponseEntity(foundUser, HttpStatus.OK); //
    }
}
