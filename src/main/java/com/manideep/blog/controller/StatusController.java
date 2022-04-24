package com.manideep.blog.controller;

import com.manideep.blog.model.Status;
import com.manideep.blog.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @PostMapping("/create")
    public ResponseEntity<Status> createStatus(@RequestBody @Valid Status status){
        Status statusDetails =  statusService.createStatus(status);
        return new ResponseEntity<>(statusDetails, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Status>> createStatus(){
        List<Status> statusDetails =  statusService.getStatus();
        return new ResponseEntity<>(statusDetails, HttpStatus.CREATED);
    }
}
