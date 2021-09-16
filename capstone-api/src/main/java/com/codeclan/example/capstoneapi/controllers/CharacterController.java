package com.codeclan.example.capstoneapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    //CHARACTER ROUTES

    //creates new character in DB
    @PostMapping(value = "/characters")
    //create response entity variable & take new Character object from the RequestBody
    public ResponseEntity<Character> saveNewCharacter(@RequestBody Character newCharacter){
        //insert character into MongoDB and return the character with its ID
        characterRepository.save(newCharacter);
        return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
    }

    //returns character by their unique ID
    @GetMapping(value= "/characters/{id}")
    public ResponseEntity getCharacterById(@PathVariable String id){
        return new ResponseEntity(characterRepository.findById(id), HttpStatus.OK);
    }

    //deletes character by ID
    @DeleteMapping(value = "/characters/{id}")
    // question mark means an empty response entity can be sent back with just the HTTP Status
    public ResponseEntity<?> deleteCharacter(@PathVariable String id){
        characterRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update character by ID
    @PutMapping(value = "/characters/{id}")
    public ResponseEntity<?> updateCharacter(@RequestBody Character updatedCharacter){
        characterRepository.save(updatedCharacter);
        return new ResponseEntity(HttpStatus.OK);
    }
}
