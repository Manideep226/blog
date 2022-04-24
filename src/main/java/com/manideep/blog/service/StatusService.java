package com.manideep.blog.service;

import com.manideep.blog.model.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatusService {
    Status createStatus(Status status);

    List<Status> getStatus();
}
