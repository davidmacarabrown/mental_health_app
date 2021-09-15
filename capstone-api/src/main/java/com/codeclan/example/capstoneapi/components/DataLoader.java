package com.codeclan.example.capstoneapi.components;


import com.codeclan.example.capstoneapi.models.character.Task;
import com.codeclan.example.capstoneapi.models.data.Contact;
import com.codeclan.example.capstoneapi.models.character.Character;
import com.codeclan.example.capstoneapi.repositories.CharacterRepository;
import com.codeclan.example.capstoneapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ContactRepository contactRepository; //import the contactRepository

    @Autowired
    CharacterRepository characterRepository;


    public DataLoader(){} //empty constructor

    public void run(ApplicationArguments args){

        //methods go here
        //CONTACTS
        contactRepository.deleteAll();
        characterRepository.deleteAll();

        Contact contactOne = new Contact("Helpline", "please call us for help", 1234567890L, "appagandomate@gmail.com");
        contactRepository.save(contactOne);

        Contact contactTwo = new Contact("another helpline", "call if you need any assistance", 1122334455L, "asdf@helpme.com");
        contactRepository.save(contactTwo);

        //CREATING CHARACTER
        Character characterOne = new Character("Naydire", 1, 0, 100 );

        //CREATING TASK
        Task taskOne = new Task("Finish the project", "you have to do it alone mate no one is gonna help you see ya", false);
        characterOne.addTask(taskOne);

        //SAVING CHARACTER
        characterRepository.save(characterOne);
    }

}
