package com.codeclan.example.capstoneapi.components;

import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner {

    public DataLoader(){} //empty constructor

    public void run(ApplicationArguments args){

        //methods go here
        //CONTACTS

        Contact contactOne = new Contact("Helpline", "please call us for help", 1234567890L, "appagandomate@gmail.com");


        Contact contactTwo = new Contact("another helpline", "call if you need any assistance", 1122334455L, "asdf@helpme.com");

        //CREATING CHARACTER
        Character characterOne = new Character("Naydire", 1, 0, 100 );

        //CREATING TASK
        Task taskOne = new Task("Finish the project", "you have to do it alone mate no one is gonna help you see ya", false);
        Task taskTwo = new Task("work on the back end", "come on your server is scuffed you have to fix it", false);



        characterOne.addTask(taskOne);
        characterOne.addTask(taskTwo);

    }
}
