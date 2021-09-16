package com.codeclan.example.capstoneapi.repositories;
import com.codeclan.example.capstoneapi.models.character.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository <Character, String> {
}
