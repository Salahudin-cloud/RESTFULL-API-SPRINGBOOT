package com.example.learnapi.demo.services;

import com.example.learnapi.demo.CommonResponse.CommonResponseGenerator;
import com.example.learnapi.demo.Entity.User;
import com.example.learnapi.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImplements implements  UserServices{


    @Autowired
    UserRepository userRepository;


    @Override
    public User addUser(User param) {
       return userRepository.save(param);

    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User param) {

        User findUser = userRepository.findById(param.getId()).get();
        findUser.setName(param.getName());
        findUser.setAge(param.getAge());

        return userRepository.save(findUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
