package com.example.taskmanager.services;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.dto.TaskRequest;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    /*return TaskResponse*/Task add(TaskRequest taskRequest);
   /*return TaskResponse*/ Task update(Long id, /*return TaskRequest*/TaskRequest taskRequest);
   /*return TaskResponse*/ List<Task> findAll();
   /*return TaskResponse*/ Optional<Task> findById(Long id);
    void delete(Long id);
    
} 
