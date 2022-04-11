package com.manideep.blog.repository;

import com.manideep.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="select p from User p where p.name LIKE CONCAT('%',:name,'%') and p.mobile LIKE CONCAT('%',:mobile,'%') and p.email LIKE CONCAT('%',:email,'%') and p.gender LIKE CONCAT('%',:gender,'%')")
    List<User> findUserByMultiParam(String name, String mobile, String email, String gender);
}
