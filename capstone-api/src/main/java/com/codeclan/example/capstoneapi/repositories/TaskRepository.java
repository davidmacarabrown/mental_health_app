package com.codeclan.example.capstoneapi.repositories;
import com.codeclan.example.capstoneapi.models.user.Task;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.ArrayList;
import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

   List<Task> findByUserId(Long id);
}
