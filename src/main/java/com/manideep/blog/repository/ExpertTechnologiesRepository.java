package com.manideep.blog.repository;

import com.manideep.blog.model.ExpertTechnologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertTechnologiesRepository extends JpaRepository<ExpertTechnologies,Integer> {

    List<ExpertTechnologies> findByTechnologyIgnoreCase(String technology);

    @Query(value="select p from ExpertTechnologies p where p.technology LIKE CONCAT('%',:technology,'%')")
    List<ExpertTechnologies> findByTechnology(String technology);
}
