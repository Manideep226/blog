package com.manideep.blog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "experts")
@Data
public class Experts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name="user_id")
    Integer userId;

    @Column(name="tech_id")
    Integer techid;
}
