package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.Userr;
import com.example.taskmanager.model.dto.AuthRequest;
import com.example.taskmanager.model.dto.TaskRequest;
import com.example.taskmanager.services.AuthenticationService;
import com.example.taskmanager.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<Task> add(@RequestBody TaskRequest task, @RequestHeader Map<String, String> headers){
        if(authenticationService.authenticate(headers).isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
       Task taskAdded = taskService.add(task);
        return new ResponseEntity<Task>(taskAdded, HttpStatus.CREATED);
    }

    @PostMapping("/nosec")
    public ResponseEntity<Task> add(@RequestBody TaskRequest task){
        Task taskAdded = taskService.add(task);
        return new ResponseEntity<Task>(taskAdded, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Task>> getall(@RequestHeader Map<String, String> headers) {
        Optional <Userr> userrOptional = authenticationService.authenticate(headers);
        if(userrOptional.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<List<Task>>(taskService.findByUserr(userrOptional.get()), HttpStatus.OK);
    }

    @GetMapping("/nosec")
    public ResponseEntity<List<Task>> getall(){
        return new ResponseEntity<List<Task>>(taskService.findAll(),HttpStatus.OK);
    }

    //filtering todo tasks
    @GetMapping("/todo")
    public ResponseEntity <List<Task>> getTodo(@RequestHeader Map<String, String> headers){
        Optional <Userr> userrOptional = authenticationService.authenticate(headers);
        if(userrOptional.isEmpty()){
            return new ResponseEntity<> (HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<List<Task>>(taskService.findTodoTasks(userrOptional.get()), HttpStatus.OK);
    }

    @GetMapping("/todo/nosec")
    public ResponseEntity<List<Task>> getTodo(){
        return new ResponseEntity<List<Task>>(taskService.findTodoTasks(), HttpStatus.OK);
    }

    //filtering in progress tasks
    @GetMapping("/inprogress")
    public ResponseEntity <List<Task>> getInProgress(@RequestHeader Map<String, String> headers){
        Optional <Userr> userrOptional = authenticationService.authenticate(headers);
        if(userrOptional.isEmpty()){
            return new ResponseEntity<> (HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<List<Task>>(taskService.findInProgressTasks(userrOptional.get()), HttpStatus.OK);
    }

    @GetMapping("/inprogress/nosec")
    public ResponseEntity<List<Task>> getInProgress(){
        return new ResponseEntity<List<Task>>(taskService.findInProgressTasks(), HttpStatus.OK);
    }

    //filtering done tasks
    @GetMapping("/done")
    public ResponseEntity <List<Task>> getDone(@RequestHeader Map<String, String> headers){
        Optional <Userr> userrOptional = authenticationService.authenticate(headers);
        if(userrOptional.isEmpty()){
            return new ResponseEntity<> (HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<List<Task>>(taskService.findDoneTasks(userrOptional.get()), HttpStatus.OK);
    }

    @GetMapping("/done/nosec")
    public ResponseEntity<List<Task>> getDone(){
        return new ResponseEntity<List<Task>>(taskService.findDoneTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getById(@PathVariable Long id, @RequestHeader Map<String, String> headers) {
        if(authenticationService.authenticate(headers).isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Optional<Task>>(taskService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/nosec/{id}")
    public ResponseEntity<Optional<Task>> getById(@PathVariable Long id){
        return new ResponseEntity<Optional<Task>>(taskService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id, @RequestHeader Map<String, String> headers) {
        if(authenticationService.authenticate(headers).isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        taskService.delete(id);
        return new ResponseEntity<String>("deleted !", HttpStatus.OK);
    }

    @DeleteMapping("/nosec/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        taskService.delete(id);
        return new ResponseEntity<String>("deleted !", HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Task> update( @RequestBody  TaskRequest taskRequest , @PathVariable("id") Long id, @RequestHeader Map<String, String> headers)
    {
        if(authenticationService.authenticate(headers).isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Task>(taskService.update(id,taskRequest), HttpStatus.OK);
    }

    @PutMapping("/nosec/{id}")
    public ResponseEntity<Task> update (@RequestBody TaskRequest taskRequest, @PathVariable("id") Long id){
        return new ResponseEntity<Task>(taskService.update(id,taskRequest), HttpStatus.OK);
    }

}
