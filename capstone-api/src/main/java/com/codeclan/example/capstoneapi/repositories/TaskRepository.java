package com.codeclan.example.capstoneapi.repositories;
import com.codeclan.example.capstoneapi.models.user.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository {

    List<Task> findByCharacterId(Long id);
    List<Task> deleteByName(String name);
}
