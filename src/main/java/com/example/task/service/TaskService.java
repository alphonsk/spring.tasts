package com.example.task.service;

import com.example.task.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TaskService {

    Task save(Task task);

    Boolean delete(int id);

    Task update(Task task);

    Task findById(int id);

    List<Task> findAll();

    List<Task> findByStatus(String status);

    List<Task> findByUserIdStatus(int userId, String status);

    List<Task> findBetween(int start, int end);


//    date format


}
