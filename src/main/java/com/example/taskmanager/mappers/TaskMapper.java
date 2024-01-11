package com.example.taskmanager.mappers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.dto.TaskRequest;
import com.example.taskmanager.repositories.UserRepository;

@Component
public class TaskMapper implements IMapper<Task, TaskRequest, Task> {

    @Autowired
    UserRepository userRepository;


    @Override
    public Task requestToObject(TaskRequest dto) {
        //Userr userr = userRepository.getById(dto.userId());

        return Task.builder()
            .title(dto.title())
            .date(dto.date())
            .description(dto.description())
            .taskStatus(dto.taskStatus())
            .reminder(dto.reminder())
            .userr(userRepository.findById(dto.userId()).get())
            .build();
    }

    @Override
    public Task objectToResponse(Task object) {
        return object;
        //cuz i do not need it right now
    }
    
}
