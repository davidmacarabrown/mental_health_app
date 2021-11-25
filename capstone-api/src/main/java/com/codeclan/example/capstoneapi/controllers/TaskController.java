package com.codeclan.example.capstoneapi.controllers;

import com.codeclan.example.capstoneapi.models.data.AppData;
import com.codeclan.example.capstoneapi.models.services.Aggregate;
import com.codeclan.example.capstoneapi.models.user.Task;
import com.codeclan.example.capstoneapi.models.user.User;
import com.codeclan.example.capstoneapi.repositories.TaskRepository;
import com.codeclan.example.capstoneapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*")
@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    AppData appData = new AppData(
            10,
            1.2,
            1,
            100,
            1.1);

    //get tasks by the user ID


    @GetMapping(value = "/users/{id}/tasks")
    public ResponseEntity<List<Task>> getTasks(@PathVariable Long id){
        System.out.printf("Task data retrieved User ID: %d %n", id);
        return new ResponseEntity<>(taskRepository.findByUserId(id), HttpStatus.OK);
    }

    //post a new task to the User by their ID

    @PostMapping(value = "/users/{userId}/tasks")
    public ResponseEntity<?> saveTask(
            @PathVariable Long userId,
            @RequestBody Task newTask){

        User  foundUser = userRepository.findById(userId).get();
        newTask.setUser(foundUser);
        newTask.markIncomplete();
        taskRepository.save(newTask);

        System.out.printf("New task saved User ID: %d %n", userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //delete a task by its ID

    @DeleteMapping(value = "users/{userId}/tasks/{taskId}")
    public ResponseEntity<List<Task>> deleteTaskByName(
            @PathVariable Long userId,
            @PathVariable Long taskId) {
        taskRepository.deleteById(taskId);

        System.out.printf("User ID: %d Task: %d deleted %n", userId, taskId);

        return new ResponseEntity<>(taskRepository.findByUserId(userId), HttpStatus.ACCEPTED);
    }

    //update a tasks details (name/description)

    @PutMapping(value = "/users/{userId}/tasks/{taskId}")
    public ResponseEntity<List<Task>> updateTask(

            @PathVariable Long userId,
            @PathVariable Long taskId,

            //request body of task object from the front end, binding it to a Task object
            @RequestBody Task updatedTask
    ){
        Task foundTask = taskRepository.findById(taskId).get();

        //database version of task is updated with the new information
        foundTask.setName(updatedTask.getName());
        foundTask.setDescription(updatedTask.getDescription());

        //task is saved and then returned
        taskRepository.save(foundTask);
        System.out.printf("User ID: %d Task: %d updated %n", userId, taskId);
        return new ResponseEntity<>(taskRepository.findByUserId(userId), HttpStatus.ACCEPTED);
    }

    //mark a task by complete by User ID and Task ID

    @PatchMapping(value = "/users/{userId}/tasks/{taskId}/markcomplete")
    public ResponseEntity<Aggregate> markComplete(

            @PathVariable Long userId,
            @PathVariable Long taskId) {

        //fetching matching task from the database by the ID from path variable
        // .get() extracts the task from the Optional<> return type of findById
        Task foundTask = taskRepository.findById(taskId).get();

        //fetching the user from the database
        User foundUser = userRepository.findById(userId).get();

        //if task in database and task in request status are different
        if (foundTask.getStatus() == false){

            //mark the task in the database side as complete
            foundTask.markComplete();

            //if difference in XP is zero:
            if (foundUser.getMaximumXp() - foundUser.getCurrentXp() == appData.getXpReward()) {

                //increase the level
                foundUser.increaseLevel();

                //set the new max health (current health * multiplier)
                double newHealth = foundUser.getHealth() * appData.getHealthMultiplier();
                foundUser.setHealth((int)newHealth);

                // reset the "current" XP
                foundUser.setCurrentXp(0);

                // increase the max XP
                double newXp = foundUser.getMaximumXp() * appData.getXpMultiplier();
                foundUser.setMaximumXp((int)newXp);

            } else {

                // just increase the xp if no level change needed
                double newXp = appData.getXpReward();
                foundUser.increaseXp((int)newXp);
            }
        }

        //modified DB task is updated with the found user
        foundTask.setUser(foundUser);

        //updated user and task are saved
        userRepository.save(foundUser);
        taskRepository.save(foundTask);

        List<Task> foundTasks = taskRepository.findByUserId(userId);

        Aggregate aggregate = new Aggregate(
                foundUser,
                foundTasks
        );

        System.out.printf("User ID: %d Task: %d marked complete %n", userId, taskId);
        return new ResponseEntity<>(aggregate, HttpStatus.OK);
    }
}