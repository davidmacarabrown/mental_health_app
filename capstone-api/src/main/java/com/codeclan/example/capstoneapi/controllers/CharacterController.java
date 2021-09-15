package com.codeclan.example.capstoneapi.controllers;

import com.codeclan.example.capstoneapi.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @GetMapping(value= "/characters/{id}")
        public ResponseEntity getCharacterByUsername(@PathVariable String id){
            return new ResponseEntity(characterRepository.findById(id), HttpStatus.OK);
    }
}
