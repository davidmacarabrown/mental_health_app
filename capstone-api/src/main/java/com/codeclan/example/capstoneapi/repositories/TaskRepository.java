package com.codeclan.example.capstoneapi.repositories;
import com.codeclan.example.capstoneapi.models.user.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository {

    List<Task> findByUserId(Long id);
}
