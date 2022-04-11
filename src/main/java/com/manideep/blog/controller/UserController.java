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
import java.util.Objects;

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
    public ResponseEntity<List<User>> getUsers(@RequestParam(value="name",required = false) String name, @RequestParam(value="mobile",required = false) String mobile, @RequestParam(value="gender",required=false) String gender, @RequestParam(value="email",required = false) String email){
        List<User> userdetails =  userService.getUsers(name,mobile,email,gender);
        return new ResponseEntity<>(userdetails,HttpStatus.OK);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Integer id){
        User userdetails =  userService.getUserbyId(id);
        return new ResponseEntity<>(userdetails,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
        User userdetails =  userService.updateUser(id,user);
        return new ResponseEntity<>(userdetails,HttpStatus.OK);
    }

}
