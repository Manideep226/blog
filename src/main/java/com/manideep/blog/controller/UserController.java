package com.manideep.blog.controller;

import com.manideep.blog.model.User;
import com.manideep.blog.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Data
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        User userdetails =  userService.createUser(user);
        return new ResponseEntity<>(userdetails, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers(){
        List<User> userdetails =  userService.getUsers();
        return new ResponseEntity<>(userdetails,HttpStatus.OK);
    }
}
