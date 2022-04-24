package com.manideep.blog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="status")
@Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="status_id")
    Integer statusId;

    @Column(name="status")
    @NotBlank(message="status cannot be empty or null")
    String status;
}
