package com.manideep.blog.repository;

import com.manideep.blog.model.BlogStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogStatusRepository extends JpaRepository<BlogStatus,Integer> {
}
