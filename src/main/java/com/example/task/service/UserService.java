package com.example.task.service;

import com.example.task.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface UserService {

    User save(User user);

    Boolean delete(int id);

    User update(User user);

    User findById(int id);

    User findByUserName(String username);

    User findByEmail(String email);

    Collection<User> findAll();
}
