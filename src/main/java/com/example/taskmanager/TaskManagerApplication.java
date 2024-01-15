package com.example.taskmanager;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskStatus;
import com.example.taskmanager.model.Userr;
import com.example.taskmanager.repositories.TaskRepository;
import com.example.taskmanager.repositories.UserRepository;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Userr userr1 = Userr.builder().username("yassine").password("yassinecher").build();
        Userr userr2 = Userr.builder().username("mehdi").password("lz").build();
        userRepository.saveAll(
            Arrays.asList(
                userr1 ,userr2
            )
        );

        taskRepository.saveAll(
            Arrays.asList(
                Task.builder()
                    .title("task1")
                    .date(LocalDate.now())
                    .description("description")
                    .taskStatus(TaskStatus.TODO)
                    .reminder(true)
                    .userr(userr1).build(),
                
                Task.builder()
                    .title("task2")
                    .date(LocalDate.now())
                    .description("description")
                    .taskStatus(TaskStatus.INPROGRESS)
                    .reminder(true)
                    .userr(userr1).build(),

                Task.builder()
                    .title("task3")
                    .date(LocalDate.now())
                    .description("description")
                    .taskStatus(TaskStatus.DONE)
                    .reminder(true)
                    .userr(userr1).build(),

                Task.builder()
                    .title("task1")
                    .date(LocalDate.now())
                    .description("description")
                    .taskStatus(TaskStatus.TODO)
                    .reminder(false)
                    .userr(userr2).build(),
                    Task.builder()
                    .title("task2")
                    .date(LocalDate.now())
                    .description("description")
                    .taskStatus(TaskStatus.INPROGRESS)
                    .reminder(true)
                    .userr(userr1).build(),

                Task.builder()
                    .title("task3")
                    .date(LocalDate.now())
                    .description("description")
                    .taskStatus(TaskStatus.DONE)
                    .reminder(true)
                    .userr(userr1).build()    
            )
        );
    }

}
