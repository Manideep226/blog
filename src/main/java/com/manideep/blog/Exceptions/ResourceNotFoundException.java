package com.manideep.blog.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
public ResourceNotFoundException(String message){
    super(message);
}
}
