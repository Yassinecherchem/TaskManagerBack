package com.example.taskmanager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.model.dto.AuthRequest;
import com.example.taskmanager.services.AuthenticationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {
    
    @Autowired
    AuthenticationService authenticationService;

    

    @PostMapping("/register")
    public Long register(@RequestBody AuthRequest authRequest){
        return authenticationService.register(authRequest);
    }
}
