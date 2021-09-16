package com.codeclan.example.capstoneapi.repositories;

import com.codeclan.example.capstoneapi.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User, Long> {

}
