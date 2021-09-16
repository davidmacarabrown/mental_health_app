package com.codeclan.example.capstoneapi.repositories;

import com.codeclan.example.capstoneapi.models.data.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
