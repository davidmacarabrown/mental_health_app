package com.codeclan.example.capstoneapi.controllers;

import com.codeclan.example.capstoneapi.models.character.Character;
import com.codeclan.example.capstoneapi.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//CHARACTER
//[DONE]characters post mapping
//TODO /characters/{id} put mapping
//TODO /characters/{id} delete mapping

//TASKS - POSSIBLE ROUTES?
//TODO /characters/{id}/tasks - get all tasks?
//TODO /characters/{id}/tasks/ - post mapping return whole object with the new ID
//TODO /characters/{id}/tasks/{id} - delete mapping
//TODO /characters/{id}/tasks/{id} - put mapping use

@RestController
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @PostMapping(value = "/characters")
    //create response entity variable & take new Character object from the RequestBody
    public ResponseEntity<Character> saveNewCharacter(@RequestBody Character character){
        //insert character into MongoDB and return the character with its ID
        characterRepository.save(character);
        return new ResponseEntity<>(character, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/characters/{id}")
    // question mark means an empty response entity can be sent back with just the HTTP Status
    public ResponseEntity<?> deleteCharacter(@PathVariable String id){
        characterRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //returns character by their unique ID
    @GetMapping(value= "/characters/{id}")
        public ResponseEntity getCharacterById(@PathVariable String id){
            return new ResponseEntity(characterRepository.findById(id), HttpStatus.OK);
    }
}
