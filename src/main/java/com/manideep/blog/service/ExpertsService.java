package com.manideep.blog.service;

import com.manideep.blog.dto.ExpertsDto;
import com.manideep.blog.model.Experts;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface ExpertsService {
    HashMap<String,String> createExpert(ExpertsDto experts);

    HashMap<String,String> deleteExpert(Integer id);


    List<Experts> getExperts();
    Experts getExpertsById(Integer id);
}
