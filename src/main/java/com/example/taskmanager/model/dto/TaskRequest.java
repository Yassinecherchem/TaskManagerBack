package com.example.taskmanager.model.dto;

import java.time.LocalDate;

import com.example.taskmanager.model.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public record TaskRequest (
    String title,
    @JsonFormat(pattern ="yyyy-MM-dd")
    LocalDate date,
    String description,
    TaskStatus taskStatus,
    boolean reminder,
    Long userId
){} 
