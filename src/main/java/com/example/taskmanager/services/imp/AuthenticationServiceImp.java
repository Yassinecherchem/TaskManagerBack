package com.example.taskmanager.services.imp;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Userr;
import com.example.taskmanager.model.dto.AuthRequest;
import com.example.taskmanager.repositories.UserRepository;
import com.example.taskmanager.services.AuthenticationService;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<Userr> authenticate(Map<String, String> headers) {
        String username = headers.get("username");
        String password = headers.get("password");
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Long register(AuthRequest authRequest) {
        
        String username = authRequest.username();
        String password = authRequest.password();
        Optional <Userr> userr =  userRepository.findByUsernameAndPassword(username, password);
        if (userr.isPresent()){
            return 0L;
        }
       Userr userr1 = userRepository.save(Userr.builder().username(username)
                                            .password(password)
                                            .build()
                            );
                                        
        return userr1.getId();
    }
    
}
