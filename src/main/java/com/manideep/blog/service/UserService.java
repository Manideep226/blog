package com.manideep.blog.service;

import com.manideep.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);

    List<User> getUsers();
}
