package com.manideep.blog.Exceptions;

import com.manideep.blog.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorResponse e = new ErrorResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(ResourceAlreadyExistsException exception, WebRequest webRequest){
        ErrorResponse e = new ErrorResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        HashMap<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return new ResponseEntity(errorMap,HttpStatus.BAD_REQUEST);
    }

}
