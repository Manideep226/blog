package com.manideep.blog.serviceimpl;

import com.manideep.blog.Exceptions.ResourceAlreadyExistsException;
import com.manideep.blog.Exceptions.ResourceNotFoundException;
import com.manideep.blog.dto.ExpertsDto;
import com.manideep.blog.model.Experts;
import com.manideep.blog.model.User;
import com.manideep.blog.repository.ExpertTechnologiesRepository;
import com.manideep.blog.repository.ExpertsRepository;
import com.manideep.blog.repository.UserRepository;
import com.manideep.blog.service.ExpertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class ExpertsServiceImpl implements ExpertsService {
    @Autowired
    ExpertsRepository expertsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExpertTechnologiesRepository expertTechnologiesRepository;

    @Override
    public HashMap<String,String> createExpert(ExpertsDto experts) {
        if(!userExists(experts.getUserId())) {
            throw new ResourceNotFoundException("user not found. Please create the user first");
        }
        HashMap<String,String> response = new HashMap<>();
        List<Experts> e = new ArrayList<>();
        for(int i=0;i<experts.getTechId().size();i++){
            Experts expertDetails = new Experts();
            expertDetails.setUserId(experts.getUserId());
            expertDetails.setTechid(experts.getTechId().get(i));
            expertDetails.setId(0);
            e.add(expertDetails);
        }
        expertsRepository.saveAll(e);
        response.put("message","created the expert");
        return response;
    }

    @Override
    @Transactional
    public HashMap<String,String> deleteExpert(Integer id) {
        if(!expertExists(id)){
            throw new ResourceAlreadyExistsException("Expert not found.");
        }
        expertsRepository.deleteExpertsById(id);
        HashMap<String,String> map= new HashMap<String,String>();
        map.put("message","deleted the expert");
        return map;
    }

    @Override
    public List<Experts> getExperts(Integer techId) {
        List<Experts> experts = new ArrayList<>();
        if(techId == null) {
            experts = expertsRepository.findAll();
            return experts;
        }
        else {
            experts = expertsRepository.findAllByTechId(techId);
        }
        if(experts.size()==0)
            throw new ResourceNotFoundException("Experts not found");
        return experts;
    }

    @Override
    public Experts getExpertsById(Integer id) {
        Experts experts= expertsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("expert not found"));

        return experts;
    }

    public boolean userExists(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            return true;
        return false;
    }

    public boolean expertExists(Integer id){
        Optional<Experts> expert = expertsRepository.findById(id);
        if(expert.isPresent())
            return true;
        return false;
    }


}
