package com.manideep.blog.service;

import com.manideep.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);

//    List<User> getUsers();

    User getUserbyId(Integer id);

    User updateUser(Integer id, User user);

    List<User> getUsers(String name, String mobile, String email, String gender);
}
