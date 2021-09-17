package com.codeclan.example.capstoneapi.controllers;

import com.codeclan.example.capstoneapi.models.data.AppData;
import com.codeclan.example.capstoneapi.models.user.Task;
import com.codeclan.example.capstoneapi.repositories.AppDataRepository;
import com.codeclan.example.capstoneapi.repositories.TaskRepository;
import com.codeclan.example.capstoneapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    AppDataRepository appDataRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users/{id}/tasks")
    public ResponseEntity<List<Task>> getTasks(@PathVariable Long id){
        return new ResponseEntity<>(taskRepository.findByUserId(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users/{id}/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        taskRepository.save(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "users/{id}/tasks/{id}")
    public ResponseEntity<Long> deleteTaskByName(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/users/{id}/tasks/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task updatedTask){

        Task foundTask = taskRepository.findById(id).get();

        AppData appData = appDataRepository.findById(1L).get();



        //if foundTask.getStatus() == false && updatedTask.getStatus() == true:
            //do the rest of things:
            //check the user level:
                //if XP till next level is equal to task XP value:
                    //increment the level by the multiplier
                    //reset current XP to zero
                    //increment the XP to next level
            //reset the XP and increment level
            //modify users max health value

        // else: (if the task is not completed yet)
        // just update the task with new info or new title...


        foundTask.setName(updatedTask.getName());
        foundTask.setDescription(updatedTask.getDescription());

        taskRepository.save(updatedTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
}

//TODO method to implement level checking and increase XP, or if level will be maxed out

// check task status in back end, compare with updatedTask, if back end = false:

//MASSIVE ASTERISK - only works if task XP value is always the same and is a derivative of level xp
//on completion of task:
//check the remaining XP to next level (if <xp to next level === value of one task's XP>
//if the task will max out the level:

//set the current XP back to zero
//else:
//increment the XP by the value of one task XP