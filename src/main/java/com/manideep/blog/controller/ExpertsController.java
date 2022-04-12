package com.manideep.blog.controller;

import com.manideep.blog.dto.ExpertsDto;
import com.manideep.blog.model.Experts;
import com.manideep.blog.model.User;
import com.manideep.blog.service.ExpertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/experts")
public class ExpertsController {

    @Autowired
    ExpertsService expertsService;

    @PostMapping("/create")
    public ResponseEntity<?> createExpert(@RequestBody ExpertsDto experts){
        HashMap<String,String> response = expertsService.createExpert(experts);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExpert(@PathVariable Integer id){
        HashMap<String,String> response = expertsService.deleteExpert(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Experts>> getExperts() {
        List<Experts> expertsDetails =  expertsService.getExperts();
        return new ResponseEntity<>(expertsDetails,HttpStatus.OK);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Experts> getExpertsById(@PathVariable Integer id) {
        Experts expertsDetails =  expertsService.getExpertsById(id);
        return new ResponseEntity<>(expertsDetails,HttpStatus.OK);

    }
}
