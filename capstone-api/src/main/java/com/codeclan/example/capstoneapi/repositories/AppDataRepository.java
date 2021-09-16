package com.codeclan.example.capstoneapi.repositories;

import com.codeclan.example.capstoneapi.models.data.AppData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppDataRepository extends JpaRepository <AppData, Long> {
}
