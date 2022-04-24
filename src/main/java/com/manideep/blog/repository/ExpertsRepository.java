package com.manideep.blog.repository;

import com.manideep.blog.model.Experts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertsRepository extends JpaRepository<Experts,Integer> {

    @Modifying
    @Query(value="delete from Experts p where p.id =:id")
    void deleteExpertsById(Integer id);

    @Query(value="select e from Experts e where e.techid =:techid")
    List<Experts> findAllByTechId(Integer techid);


}
