package com.example.taskmanager.services;

import java.util.Map;
import java.util.Optional;

import com.example.taskmanager.model.Userr;
import com.example.taskmanager.model.dto.AuthRequest;

public interface AuthenticationService{
    Optional<Userr> authenticate(Map<String, String> headers);
    Long register(AuthRequest authRequest);  
} 