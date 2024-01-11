package com.example.taskmanager.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.model.Userr;

@Repository
public interface UserRepository extends JpaRepository<Userr, Long> {
    
    Optional <Userr> findByUsernameAndPassword(String username, String password);
}
