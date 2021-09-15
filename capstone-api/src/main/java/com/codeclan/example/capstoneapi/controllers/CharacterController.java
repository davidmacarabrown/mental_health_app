package com.codeclan.example.capstoneapi.controllers;

import com.codeclan.example.capstoneapi.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//CHARACTER
//TODO /characters post mapping
//TODO /characters/{id} put mapping
//TODO /characters/{id} delete mapping

//TASKS - POSSIBLE ROUTES?
//TODO /characters/{id}/tasks - get all tasks?
//TODO /characters/{id}/tasks/{id} - post mapping
//TODO /characters/{id}/tasks/{id} - delete mapping
//TODO /characters/{id}/tasks/{id} - put mapping

@RestController
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @GetMapping(value= "/characters")
    public ResponseEntity getAllCharacters(){
        return new ResponseEntity(characterRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value= "/characters/{id}")
        public ResponseEntity getCharacterByUsername(@PathVariable String id){
            return new ResponseEntity(characterRepository.findById(id), HttpStatus.OK);
    }
}
