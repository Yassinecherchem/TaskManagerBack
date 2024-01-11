package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.dto.TaskRequest;
import com.example.taskmanager.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> add(@RequestBody TaskRequest task){
       Task taskAdded = taskService.add(task);
        return new ResponseEntity<Task>(taskAdded, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Task>> getall() {
        return new ResponseEntity<List<Task>>(taskService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getById(@PathVariable Long id) {
        return new ResponseEntity<Optional<Task>>(taskService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        taskService.delete(id);
        return new ResponseEntity<String>("deleted !", HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Task> update( @RequestBody  TaskRequest taskRequest , @PathVariable("id") Long id)
    {
        return new ResponseEntity<Task>(taskService.update(id,taskRequest), HttpStatus.OK);
    }


}
