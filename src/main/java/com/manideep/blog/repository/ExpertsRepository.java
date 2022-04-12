package com.manideep.blog.repository;

import com.manideep.blog.model.Experts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertsRepository extends JpaRepository<Experts,Integer> {

    @Modifying
    @Query(value="delete from Experts p where p.id =:id")
    void deleteExpertsById(Integer id);



}
