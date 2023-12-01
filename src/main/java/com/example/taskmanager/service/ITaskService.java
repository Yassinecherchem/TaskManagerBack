package com.example.taskmanager.service;

import com.example.taskmanager.service.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskService extends JpaRepository<Task, Long> {
    List<Task> findByDescription (@Param("description") String description);
}
