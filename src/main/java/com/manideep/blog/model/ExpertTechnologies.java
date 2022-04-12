package com.manideep.blog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="expert_technologies")
@Data
public class ExpertTechnologies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name="technology")
    @NotBlank(message="technology cannot be empty")
    String technology;
}
