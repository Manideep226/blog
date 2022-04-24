package com.manideep.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "blog")
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_id")
    private Integer blogId;

    @Column(name="title")
    @NotBlank(message="Title cannot be empty")
    private String title;

    @Column(name="blog_content")
    @NotBlank(message="Blog Content cannot be empty")
    private String blogContent;

    @Column(name="technology")
    @NotNull(message="Technology cannot be blank")
    private Integer technology;

    @Column(name="expert")
    @NotNull(message="Expert cannot be blank")
    private Integer expert;

    @Column(name="created_by")
    private Integer createdBy;

    @Column(name="created_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="")
    private Date createdAt;

    @Column(name="updated_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="")
    private Date updatedAt;

}
