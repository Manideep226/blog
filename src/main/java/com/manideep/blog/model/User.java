package com.manideep.blog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name="name")
    @NotNull(message = "Name cannot be empty")
    private String name;

    @Column(name="mobile",nullable = false)
//    @NotNull(message = "Mobile cannot be empty")
    @Pattern(regexp = "^\\d{10}$")
    private String mobile;


    @Column(name="email")
    @NotNull(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name="gender")
    @NotNull(message = "Gender cannot be empty")
    private String gender;
}
