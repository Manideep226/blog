package com.manideep.blog.service;

import com.manideep.blog.model.ExpertTechnologies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnologiesService {
    ExpertTechnologies createTechnologies(ExpertTechnologies expertTechnologies);

    List<ExpertTechnologies> getExpertTechnologies(String technologies);
}
