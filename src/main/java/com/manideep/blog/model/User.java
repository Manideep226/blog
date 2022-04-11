package com.manideep.blog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name="name")
    @NotBlank(message = "Name cannot be null")
    private String name;

    @Column(name="mobile")
    @Pattern(regexp="^\\d{10}$", message = "Enter valid mobile Number")
    private String mobile;

    @Column(name="email")
    @NotBlank(message = "Email cannot be null")
    private String email;

    @Column(name="gender")
    @NotBlank(message = "Gender cannot be null")
    private String gender;
}
