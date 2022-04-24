package com.manideep.blog.repository;

import com.manideep.blog.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}
