package com.example.taskmanager.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.mappers.IMapper;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.dto.TaskRequest;
import com.example.taskmanager.repositories.TaskRepository;
import com.example.taskmanager.services.TaskService;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    IMapper<Task, TaskRequest, Task> mapper;

    @Override
    public Task add(TaskRequest taskRequest) {
        Task task = mapper.requestToObject(taskRequest);

        return  taskRepository.save(task);
    }

    @Override
    public Task update(Long id, TaskRequest taskRequest) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()){
            return null;
        }
        Task newTask = mapper.requestToObject(taskRequest);
        newTask.setId(id);
        return taskRepository.save(newTask);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    
}