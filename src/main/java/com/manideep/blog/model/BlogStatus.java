package com.manideep.blog.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="blog_status")
@Data
public class BlogStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_status_id")
    private Integer blogStatusId;

    @Column(name="blog_id")
    private Integer blogId;

    @Column(name="status")
    private Integer status;

    @Column(name="comments")
    private String comments;
}
