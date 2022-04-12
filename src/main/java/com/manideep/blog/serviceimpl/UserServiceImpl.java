package com.manideep.blog.serviceimpl;

import com.manideep.blog.Exceptions.ResourceNotFoundException;
import com.manideep.blog.model.User;
import com.manideep.blog.repository.UserRepository;
import com.manideep.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public List<User> getUsers(String name, String mobile, String email, String gender) {
        if(StringUtils.isEmpty(name)){
            name="";
        }
        if(StringUtils.isEmpty(mobile)){
            mobile="";
        }
        if(StringUtils.isEmpty(email)){
            email="";
        }if(StringUtils.isEmpty(gender)){
            gender="";
        }
        List<User> userDetails = userRepository.findUserByMultiParam(name,mobile,email,gender);
        if(Objects.isNull(userDetails) || userDetails.size() == 0){
            throw new ResourceNotFoundException("users not found");
        }
        return userDetails;
    }

    @Override
    public User getUserbyId(Integer id) {
        Optional<User> userDetails = userRepository.findById(id);
        if(userDetails.isPresent()){
            return userDetails.get();
        } else {
            throw new ResourceNotFoundException("user not found");
        }
    }

    @Override
    public User updateUser(Integer id, User user) {
        Optional<User> userDetails = userRepository.findById(id);
        if(userDetails.isPresent()){

            userDetails.get().setEmail(user.getEmail());
            userDetails.get().setName(user.getName());
            userDetails.get().setGender(user.getGender());
            userDetails.get().setMobile(user.getMobile());

            User u = userRepository.save(userDetails.get());
            return u;
        } else {
            throw new ResourceNotFoundException("user not found");
        }
    }


}
