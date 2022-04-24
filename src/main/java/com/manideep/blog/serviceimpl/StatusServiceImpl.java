package com.manideep.blog.serviceimpl;

import com.manideep.blog.Exceptions.ResourceNotFoundException;
import com.manideep.blog.model.Status;
import com.manideep.blog.repository.StatusRepository;
import com.manideep.blog.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public Status createStatus(Status status) {
        Status s = statusRepository.save(status);
        return s;
    }

    @Override
    public List<Status> getStatus() {
        List<Status> s = statusRepository.findAll();
        if(s.size() == 0)
            throw new ResourceNotFoundException("status not found");
        return s;
    }
}
