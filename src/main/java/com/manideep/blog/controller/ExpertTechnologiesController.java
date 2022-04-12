package com.manideep.blog.controller;

import com.manideep.blog.model.ExpertTechnologies;
import com.manideep.blog.service.TechnologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class ExpertTechnologiesController {

    @Autowired
    TechnologiesService technologiesService;

    @PostMapping("/create")
    public ResponseEntity<ExpertTechnologies> createTechnolohgies(@RequestBody ExpertTechnologies expertTechnologies){
        ExpertTechnologies technologies = technologiesService.createTechnologies(expertTechnologies);
        return new ResponseEntity<>(technologies, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<ExpertTechnologies>> getExpertTechnologies(@RequestParam(name="technologies",required=false) String technologies){
        List<ExpertTechnologies> t = technologiesService.getExpertTechnologies(technologies);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

}
