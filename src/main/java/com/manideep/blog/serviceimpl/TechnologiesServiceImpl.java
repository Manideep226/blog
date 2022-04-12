package com.manideep.blog.serviceimpl;

import com.manideep.blog.Exceptions.ResourceAlreadyExistsException;
import com.manideep.blog.Exceptions.ResourceNotFoundException;
import com.manideep.blog.model.ExpertTechnologies;
import com.manideep.blog.repository.ExpertTechnologiesRepository;
import com.manideep.blog.service.TechnologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class TechnologiesServiceImpl implements TechnologiesService {
    @Autowired
    ExpertTechnologiesRepository expertTechnologiesRepository;

    @Override
    public ExpertTechnologies createTechnologies(ExpertTechnologies expertTechnologies) {
        List<ExpertTechnologies> technologies1 = expertTechnologiesRepository.findByTechnologyIgnoreCase(expertTechnologies.getTechnology());
        if(Objects.isNull(technologies1)|| technologies1.size() == 0){
            ExpertTechnologies technologies = expertTechnologiesRepository.save(expertTechnologies);
            return technologies;
        } else {
            throw new ResourceAlreadyExistsException("Technology all ready exists");
        }
    }

    @Override
    public List<ExpertTechnologies> getExpertTechnologies(String technologies) {
        if(StringUtils.isEmpty(technologies))
            technologies="";
        List<ExpertTechnologies> expertTechnologies = expertTechnologiesRepository.findByTechnology(technologies);
        if(expertTechnologies.size() != 0){
            return expertTechnologies;
        } else {
            throw new ResourceNotFoundException("Technology doesn't exist");
        }
    }


}
