package com.manideep.blog.Exceptions;

public class UserNotFoundException extends RuntimeException {
public UserNotFoundException(String message){
    super(message);
}
}
