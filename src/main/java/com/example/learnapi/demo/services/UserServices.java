package com.example.learnapi.demo.services;

import com.example.learnapi.demo.Entity.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserServices {

    User addUser(User param);

    List<User> getAllUser();

    User getById(Long id);

    User updateUser(User param);

    void deleteUser(Long id);
}
