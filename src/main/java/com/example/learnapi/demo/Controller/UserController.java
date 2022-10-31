package com.example.learnapi.demo.Controller;

import com.example.learnapi.demo.CommonResponse.CommonResponse;
import com.example.learnapi.demo.CommonResponse.CommonResponseGenerator;
import com.example.learnapi.demo.Entity.User;
import com.example.learnapi.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @Autowired
    UserServices userServices;

    @GetMapping("/test")
    public CommonResponse test() {
        try {
            return commonResponseGenerator.successResponse( "Success","Connected");
        }catch (Exception e ) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "adduser")
    public CommonResponse<User> addNewUser(@RequestBody User param) {

        try {
            User addUser = userServices.addUser(param);
            return commonResponseGenerator.successResponse(addUser, "User Added Successfully!");
        }catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "getAllUser")
    public CommonResponse<List<User>> getAllUser() {
        try {
            List<User> userList = userServices.getAllUser();

            return commonResponseGenerator.successResponse(userList , "Success get all user");
        }catch (Exception e ) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getUserById")
    public CommonResponse<User> getById(@RequestParam Long id) {

        try {
            User user = userServices.getById(id);
            return commonResponseGenerator.successResponse(user, "Success get User by id " + id);
        }catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }


    @PostMapping(value = "updateUser")
    public  CommonResponse<User> updateUser(@RequestBody User param) {

        try {
            User userUpdate = userServices.updateUser(param);
            return commonResponseGenerator.successResponse(userUpdate , "update user success");
        }catch (Exception e ) {
            return commonResponseGenerator.failedResponse(e.getMessage() + " For id : " + param.getId());
        }
    }



    @GetMapping(value = "deleteCar")
    public List<User> delete(@RequestParam Long id) {
        try {
            userServices.deleteUser(id);
            List<User> userList = userServices.getAllUser();
            return (List<User>) commonResponseGenerator.successResponse(userList, "success delete user");
        }catch (Exception e ) {
            return (List<User>) commonResponseGenerator.failedResponse(e.getMessage());
        }

    }




}
