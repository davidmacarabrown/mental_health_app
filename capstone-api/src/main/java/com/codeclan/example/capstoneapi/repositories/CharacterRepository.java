package com.codeclan.example.capstoneapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository <Character, String> {
}
