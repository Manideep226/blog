package com.manideep.blog.serviceimpl;

import Exceptions.UserNotFoundException;
import com.manideep.blog.model.User;
import com.manideep.blog.repository.UserRepository;
import com.manideep.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User createUser(User user) {
        User userDetails = userRepository.save(user);
        return userDetails;
    }

    @Override
    public List<User> getUsers() {
        List<User> userDetails = userRepository.findAll();
        if(Objects.isNull(userDetails)){
            throw new UserNotFoundException("users not found");
        }
        return userDetails;
    }


}
