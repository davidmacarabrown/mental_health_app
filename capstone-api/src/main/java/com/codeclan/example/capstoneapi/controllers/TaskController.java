package com.codeclan.example.capstoneapi.controllers;

import com.codeclan.example.capstoneapi.models.user.Task;
import com.codeclan.example.capstoneapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

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
    public ResponseEntity deleteTaskByName(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/users/{id}/tasks/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task updatedTask){
        taskRepository.save(updatedTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
}
