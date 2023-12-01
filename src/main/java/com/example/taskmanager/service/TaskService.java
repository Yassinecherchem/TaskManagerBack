package com.example.taskmanager.service;

import com.example.taskmanager.service.model.Task;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final List<Task> repo = List.of(
            new Task(1L, "task 1", new Date(2023, 11, 25), "description 1", false),
            new Task(1L, "task 2", new Date(2023, 11, 26), "description 2", false),
            new Task(1L, "task 3", new Date(2023, 11, 27), "description 3", false),
            new Task(1L, "task 4", new Date(2023, 11, 28), "description 4", false),
            new Task(1L, "task 5", new Date(2023, 11, 29), "description 5", false)
    );
    private ITaskService iTaskService;
    public TaskService(ITaskService iTaskService){
        this.iTaskService=iTaskService;
    }

    public Optional<Task> findById(Long id){
       return iTaskService.findById(id);
    }
    public List<Task> findAll(){
        return repo;
    }
    public void addTask(Task task){
        iTaskService.save(task);
    }
    public void addTasks(List<Task> tasks){
        iTaskService.saveAll(tasks);
    }

    public void deleteTask(Task task){
        iTaskService.delete(task);
    }
    public void deleteTasks(List<Task> tasks){
        iTaskService.deleteAll(tasks);
    }
    public void updateTaskTitle(Task task, String title){
        task.setTitle(title);
        iTaskService.save(task);

    }
    public void updateTaskDescription(Task task, String description){
        task.setDescription(description);
        iTaskService.save(task);

    }
    public void updateTaskDate(Task task, Date date){
        task.setDate(date);
        iTaskService.save(task);
    }
    public void setReminderTrue(Task task){
        task.setReminder(true);
        iTaskService.save(task);
    }
    public void setRemainderFalse(Task task){
        task.setReminder(false);
        iTaskService.save(task);
    }






}
