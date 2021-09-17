package com.codeclan.example.capstoneapi.controllers;

import com.codeclan.example.capstoneapi.models.data.AppData;
import com.codeclan.example.capstoneapi.models.user.Task;
import com.codeclan.example.capstoneapi.models.user.User;
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
    UserRepository userRepository;

    AppData appData = new AppData(
            10,
            1.2,
            1,
            100,
            1.1);

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

    @PutMapping(value = "/users/{userId}/tasks/{taskId}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long userId,
            @PathVariable Long taskId,
            @RequestBody Task updatedTask){

        Task foundTask = taskRepository.findById(taskId).get();
        User foundUser = userRepository.getById(userId);


        //if task in database and task in request status are different
        if (foundTask.getStatus() == false &&  updatedTask.getStatus() == true){

            //mark the task in the database side as complete
            foundTask.markComplete();

            //if difference in XP is zero:
            if (foundUser.getMaximumXp() - foundUser.getCurrentXp() == appData.getXpReward()) {

                // if true: increase the level
                foundUser.increaseLevel();

                //increase the max health
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

        //database side task is updated with changes
        foundTask.setName(updatedTask.getName());
        foundTask.setDescription(updatedTask.getDescription());
        foundTask.setUser(foundUser);

        //updated user and task are saved
        userRepository.save(foundUser);
        taskRepository.save(updatedTask);
        return new ResponseEntity<>(foundTask, HttpStatus.OK);
    }
}

//TODO ask what will happen on the front end to a task once it is completed, will it disappear or will it stay